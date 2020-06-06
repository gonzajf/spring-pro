package com.gonzajf.spring.ch4;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyEditorBean {

    private byte[] bytes;
    private Character character;
    private Class cls;
    private Boolean trueOrFalse;
    private List<String> stringList;
    private Date date;
    private Float floatValue;
    private File file;
    private InputStream stream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String trimString;
    private URL url;

    public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

        @Override
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public Boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getTrimString() {
        return trimString;
    }

    public void setTrimString(String trimString) {
        this.trimString = trimString;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
    public static void main(String... args) throws Exception {
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-config-01.xml");
        ctx.refresh();
        PropertyEditorBean bean =
                (PropertyEditorBean) ctx.getBean("builtInSample");
        ctx.close();
    }

}