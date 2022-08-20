@GrabConfig(systemClassLoader = true)
@Grab(group = 'org.postgresql', module = 'postgresql', version = '42.4.1')
import groovy.sql.Sql

def url = 'jdbc:postgresql://localhost:5432/postgres'
def user = 'postgres'
def password = 'postgres'
def driver = 'org.postgresql.Driver'
def sql = Sql.newInstance(url, user, password, driver)
println "Let's sum!"


try {
    def output = []
    sql.eachRow("select * from links") { row ->
        output.push(row[0])
    }

    def rowNum = 0
    sql.query('select * from links') { resultSet ->
        while (resultSet.next()) {
            def id = resultSet.getString(1)
            def urlFromDB = resultSet.getString('url')
            println(id);
            // The value of the variable is printed to the console
            println(urlFromDB);
            //assert expected[rowNum++] == "$first $last"
        }
    }
// using explicit argument
    output.each { val -> println val }
    //return output.sort()
} finally {
    sql.close()
}
