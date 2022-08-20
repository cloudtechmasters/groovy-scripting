/*@GrabConfig(systemClassLoader = true)
@Grab(group = 'org.postgresql', module = 'postgresql', version = '42.4.1')*/
// https://mvnrepository.com/artifact/mysql/mysql-connector-java
/*@Grapes(
        @Grab(group='mysql', module='mysql-connector-java', version='8.0.30')
)*/
@GrabConfig(systemClassLoader = true)
@Grab(group = 'mysql', module = 'mysql-connector-java', version = '8.0.30')
import groovy.sql.Sql

def url = 'jdbc:mysql://localhost:3306/testdb'
def user = 'root'
def password = 'root'
def driver = 'com.mysql.cj.jdbc.Driver'
def sql = Sql.newInstance(url, user, password, driver)
println "Let's sum!"

try {
    def output = []
    sql.eachRow("select * from testdb.employee") { row ->
        output.push(row[0])
    }
// using explicit argument
    output.each { val -> println val }
    //return output.sort()
} finally {
    sql.close()
}
