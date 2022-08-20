class Example {
    public static void main(String[] args) {
        println(args[0]);
        // Defining a variable in lowercase
        int x = 5;

        // Defining a variable in uppercase
        int X = 6;

        // Defining a variable with the underscore in it's name
        def _Name = "Joe";

        println(x);
        println(X);
        println(_Name);


        def empid = 100;
        println(empid);

        for (int i = 0; i <= 5; i++) {
            println(i);
        }
        println("iterationg loop")
        def empids = [100, 200, 300]
// using implicit argument
        empids.each { println it }

        def empnames=["vamsikrm","srinadh","krishna"]
        empnames.each {println(it)}

        // explicit arguments are required
        empnames.eachWithIndex { val, idx -> println "$val in position $idx" }

        println("iteraing with map..........")
        def empdata = [
                empname : 'vamsikrm',
                empage : 30,
                empemail : 'cloudtechmasters@gmail.com',
        ]

       /* for (field in empdata.keySet()) {
            println(field)
        }*/
        /*def my_keys = empdata.keySet()
        println(my_keys.getClass())*/

       /* // using implicit argument
        empdata.each { println "key: ${it.key}, value: ${it.value}"}
*/

        /*for (value in empdata.values()) {
            println(value)
        }*/

        for (entry in empdata.entrySet()) {
            println(entry.key)
            println(entry.value)
        }

    }
}
