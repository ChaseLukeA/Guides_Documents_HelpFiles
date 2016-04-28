##Back-tracing Web Services from Properties with Spring

J**In src/main/resources/ .properties file:**

`<nameInFile>.<whatever>`

**In src/main/webapp/WEB-INF/config/ws-config.xml:**

    <bean id="<newWebServiceId>" ...>
      <property ... value="<projectName/PropertiesFileName>">
    </bean>

**Search project for <newWebServiceId>**

**In src/main/java/.../file.java:**

    @Autowired
    private <NewWebServiceId_datatype> <newWebServiceId>;

