package com.jk.modules.generator.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.jk.common.exception.RRException;
import com.jk.common.utils.DateUtils;
import com.jk.modules.generator.entity.TableEntity;
import com.jk.modules.generator.entity.GeneratorParamEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.jk.modules.generator.entity.ColumnEntity;

/**
 * 代码生成器 工具类
 *
 */
public class GenUtils {

	public static List<String> getTemplates() {
		List<String> templates = new ArrayList<String>();
		templates.add("velocity/template/Entity.java.vm");
		templates.add("velocity/template/Mapper.java.vm");
		templates.add("velocity/template/Mapper.xml.vm");
		templates.add("velocity/template/Manager.java.vm");
		templates.add("velocity/template/ManagerImpl.java.vm");
		templates.add("velocity/template/Service.java.vm");
		templates.add("velocity/template/ServiceImpl.java.vm");
		templates.add("velocity/template/Controller.java.vm");
		templates.add("velocity/template/list.html.vm");
		templates.add("velocity/template/list.js.vm");
		templates.add("velocity/template/add.html.vm");
		templates.add("velocity/template/add.js.vm");
		templates.add("velocity/template/edit.html.vm");
		templates.add("velocity/template/edit.js.vm");
		templates.add("velocity/template/menu.sql.vm");
		return templates;
	}

	/**
	 * 生成代码
	 */
	public static void generatorCode(TableEntity table, List<ColumnEntity> columns, GeneratorParamEntity params,
									 ZipOutputStream zip) {
		// 配置信息
		Configuration config = getConfig();

		// 表名转换成Java类名
		String className = tableToJava(table.getTableName(), config.getString("tablePrefix"));// sys_user -> SysUser
		table.setClassName(className);// SysUser
		table.setObjName(StringUtils.uncapitalize(className));// sysUser

		// 列信息
		for (ColumnEntity column : columns) {
			// 列名转换，java属性名及对应方法名
			String columnName = columnToJava(column.getColumnName());// user_id -> UserId
			column.setFieldName(StringUtils.uncapitalize(columnName));// userId
			column.setMethodName(columnName);// UserId
			// 列数据类型转换
			String fieldType = config.getString(column.getDataType(), "unknowType");
			column.setFieldType(fieldType);
			// 主键判断
			if ("PRI".equals(column.getColumnKey()) && table.getPk() == null) {
				table.setPk(column);
			}
		}
		table.setColumns(columns);

		// 没主键，则第一个字段为主键
		if (table.getPk() == null) {
			table.setPk(table.getColumns().get(0));
		}

		// 设置velocity资源加载器
		Properties prop = new Properties();
		prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(prop);

		// 封装模板数据
		Map<String, Object> map = new HashMap<>();
		map.put("tableName", table.getTableName());
		map.put("comments", table.getTableComment());
		map.put("pk", table.getPk());
		map.put("className", table.getClassName());
		map.put("objName", table.getObjName());
		map.put("functionCode", params.getFunctionCode());
		map.put("requestMapping", params.getRequestMapping());
		map.put("viewPath", params.getViewPath());
		map.put("authKey", urlToAuthKey(params.getRequestMapping()));
		map.put("columns", table.getColumns());
		map.put("package", config.getString("package"));
		map.put("module", params.getModule());
		map.put("author", config.getString("author"));
		map.put("email", config.getString("email"));
		map.put("url", config.getString("url"));
		map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_CHN_PATTERN));
		VelocityContext context = new VelocityContext(map);

		// 获取模板列表
		List<String> templates = getTemplates();
		for (String template : templates) {
			// 渲染模板
			StringWriter sw = new StringWriter();
			Template tpl = Velocity.getTemplate(template, "UTF-8");
			tpl.merge(context, sw);

			try {
				// 添加到zip
				if ("1".equals(params.getType())) {
					zip.putNextEntry(new ZipEntry(getFileName(template, table.getClassName(), params.getModule(),
							params.getFunctionCode(), config.getString("package"))));
				} else {
					zip.putNextEntry(new ZipEntry(getFileName(template, table.getClassName())));
				}
				IOUtils.write(sw.toString(), zip, "UTF-8");
				IOUtils.closeQuietly(sw);
				zip.closeEntry();
			} catch (IOException e) {
				throw new RRException("渲染模板失败，表名：" + table.getTableName(), e);
			}
		}
	}

	/**
	 * 列名转换成Java属性名
	 */
	public static String columnToJava(String columnName) {
		return WordUtils.capitalizeFully(columnName, new char[] { '_' }).replace("_", "");
	}

	/**
	 * 表名转换成Java类名
	 */
	public static String tableToJava(String tableName, String tablePrefix) {
		if (StringUtils.isNotBlank(tablePrefix)) {
			tableName = tableName.replace(tablePrefix, "");
		}
		return columnToJava(tableName);
	}

	/**
	 * 权限标识
	 * 
	 * @param url
	 * @return
	 */
	public static String urlToAuthKey(String url) {
		return url.replace("/", ":");
	}

	/**
	 * 获取配置信息
	 */
	public static Configuration getConfig() {
		try {
			return new PropertiesConfiguration("velocity/generator.properties");
		} catch (ConfigurationException e) {
			throw new RRException("获取配置文件失败，", e);
		}
	}

	/**
	 * 获取文件名，不带包名
	 * 
	 * @param template
	 * @param className
	 * @return
	 */
	public static String getFileName(String template, String className) {
		String packagePath = "java" + File.separator;
		if (template.contains("Entity.java.vm")) {
			return packagePath + className + "Entity.java";
		}

		if (template.contains("Mapper.java.vm")) {
			return packagePath + className + "Mapper.java";
		}

		if (template.contains("Mapper.xml.vm")) {
			return packagePath + className + "Mapper.xml";
		}

		if (template.contains("Manager.java.vm")) {
			return packagePath + className + "Manager.java";
		}

		if (template.contains("ManagerImpl.java.vm")) {
			return packagePath + className + "ManagerImpl.java";
		}

		if (template.contains("Service.java.vm")) {
			return packagePath + className + "Service.java";
		}

		if (template.contains("ServiceImpl.java.vm")) {
			return packagePath + className + "ServiceImpl.java";
		}

		if (template.contains("Controller.java.vm")) {
			return packagePath + className + "Controller.java";
		}

		if (template.contains("list.html.vm")) {
			return "view" + File.separator + "list.html";
		}

		if (template.contains("add.html.vm")) {
			return "view" + File.separator + "add.html";
		}

		if (template.contains("edit.html.vm")) {
			return "view" + File.separator + "edit.html";
		}

		if (template.contains("list.js.vm")) {
			return "js" + File.separator + "list.js";
		}

		if (template.contains("add.js.vm")) {
			return "js" + File.separator + "add.js";
		}

		if (template.contains("edit.js.vm")) {
			return "js" + File.separator + "edit.js";
		}

		if (template.contains("menu.sql.vm")) {
			return className.toLowerCase() + "_menu.sql";
		}

		return null;
	}

	/**
	 * 获取文件名，带包名
	 */
	public static String getFileName(String template, String className, String module, String functionCode,
			String packageName) {
		String packagePath = "java" + File.separator;
		if (StringUtils.isNotBlank(packageName)) {
			packagePath += packageName.replace(".", File.separator) + File.separator + "modules" + File.separator + module + File.separator;
		}

		if (template.contains("Entity.java.vm")) {
			return packagePath + "entity" + File.separator + className + "Entity.java";
		}

		if (template.contains("Mapper.java.vm")) {
			return packagePath + "dao" + File.separator + className + "Mapper.java";
		}

		if (template.contains("Mapper.xml.vm")) {
			return packagePath + "dao" + File.separator + className + "Mapper.xml";
		}

		if (template.contains("Manager.java.vm")) {
			return packagePath + "manager" + File.separator + className + "Manager.java";
		}

		if (template.contains("ManagerImpl.java.vm")) {
			return packagePath + "manager" + File.separator + "impl" + File.separator + className + "ManagerImpl.java";
		}

		if (template.contains("Service.java.vm")) {
			return packagePath + "service" + File.separator + className + "Service.java";
		}

		if (template.contains("ServiceImpl.java.vm")) {
			return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
		}

		if (template.contains("Controller.java.vm")) {
			return packagePath + "controller" + File.separator + className + "Controller.java";
		}

		if (template.contains("list.html.vm")) {
			return "view" + File.separator + functionCode + File.separator + "list.html";
		}

		if (template.contains("add.html.vm")) {
			return "view" + File.separator + functionCode + File.separator + "add.html";
		}

		if (template.contains("edit.html.vm")) {
			return "view" + File.separator + functionCode + File.separator + "edit.html";
		}

		if (template.contains("list.js.vm")) {
			return "js" + File.separator + functionCode + File.separator + "list.js";
		}

		if (template.contains("add.js.vm")) {
			return "js" + File.separator + functionCode + File.separator + "add.js";
		}

		if (template.contains("edit.js.vm")) {
			return "js" + File.separator + functionCode + File.separator + "edit.js";
		}

		if (template.contains("menu.sql.vm")) {
			return className.toLowerCase() + "_menu.sql";
		}

		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtils.uncapitalize("user_id"));
		System.out.println(StringUtils.uncapitalize(columnToJava("user_id")));
	}

}
