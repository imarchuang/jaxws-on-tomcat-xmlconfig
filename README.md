# jaxws-on-tomcat-xmlconfig

The key point of this project is to show what kind of "additional" configurations are required to deploy jaxws services to Tomcat server.

```
    <listener>
        <listener-class>com.sun.xml.ws.transport.http.servlet.WSServletContextListener</listener-class>
    </listener>
    <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.sun.xml.ws.transport.http.servlet.WSServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
    <session-config>
        <session-timeout>120</session-timeout>
    </session-config>
```

The configuration above is usually not required in AS like WebSphere, GlassFish or JBoss, as jaxws is better supported there.

Below is the `sun-jaxws.xml`:
```
<?xml version="1.0" encoding="UTF-8"?>
<endpoints
        xmlns="http://java.sun.com/xml/ns/jax-ws/ri/runtime"
        version="2.0">
    <endpoint
            name="HelloWorld"
            implementation="com.imarchuang.jaxws.HelloWorldWsImpl"
            url-pattern="/hello"/>
</endpoints>
```

Dependencies in order to deploy it to tomcat:
```
     <dependencies>
        <dependency>
            <groupId>com.sun.xml.ws</groupId>
            <artifactId>jaxws-rt</artifactId>
            <version>2.1.4</version>
            <exclusions>
                <exclusion>
                    <artifactId>saaj-impl</artifactId>
                    <groupId>com.sun.xml</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>mimepull</artifactId>
                    <groupId>org.jvnet</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>stax-api</artifactId>
                    <groupId>javax.xml.stream</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>saaj-impl</artifactId>
                    <groupId>com.sun.xml.messaging.saaj</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>jaxb-api</artifactId>
                    <groupId>javax.xml.bind</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>activation</artifactId>
                    <groupId>javax.activation</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>jaxws-api</artifactId>
                    <groupId>javax.xml.ws</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>resolver</artifactId>
                    <groupId>com.sun.org.apache.xml.internal</groupId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>
```
