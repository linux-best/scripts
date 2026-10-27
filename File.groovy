pipeline {
    agent any

    environment {
        VAR_1 = 'Hello'
    }

    stages {
        stage('Groovy_File') {
            environment {
                VAR_2 = 'World'
            }
            steps {
                script { // for loop
                    def gf_var = 'I am so good :)'
                    def gf_num = 1
                    println("STAGE - Groovy_File -> ${env.VAR_1} ${env.VAR_2}, ${gf_var} \nnumber:${gf_num}...!")
                }
            }
        }
        stage('Groovy_File_1') {
            steps {
                script {
                    // comment one line .
                    /*
                        multiple line commnet 
                    */
                    Integer gf1_number = 2 // def number = 2
                    def gf1_var = 'Hello' // string var = 'hello'
                    def gf1_num = 1 // int num = 1
                    String gf1_Combined = "${gf1_var}"+' World'
                    println("${gf1_var} World ...!\nnumber : ${gf1_num},"+gf1_number)
                    print(gf1_var)
                    print(gf1_num)
                    // Numbers
                    Integer gf1_X=1,gf1_Y=2            // it checks to see if both objects reference the same place in memory. But,  
                    def gf1_Z = gf1_X+gf1_Y            // the equals method is actually meant to compare the contents of 2 objects
                    print(gf1_Z)                       // and not their location in memory.
                    print "${gf1_Z}"            
                    println("${gf1_Z}")
                    // Indexing & Slicing
                    println(gf1_Combined[3])
                    println(gf1_Combined[-1])
                    println(gf1_Combined[3..7])
                    println(gf1_Combined[-1..3])
                    def gf1_index = (gf1_Combined[8]+gf1_Combined[4]+gf1_Combined[2..3]) // Creating a word
                    print("WORD : ${gf1_index} & length : "+gf1_index.length())
                    // string methods 
                    Integer gf1_Height = 1
                    double gf1_MyHeight = 1.80
                    Integer gf1_i = gf1_MyHeight.intValue()
                    double gf1_d =(gf1_Height.doubleValue() * (10 ** 2))
                    print "you are ${gf1_d}cm tall & i am ${gf1_i}cm tall"
                    println("max : "+Math.max(gf1_Height,2))
                    println("min : "+Math.min(12,11))
                    print(gf1_i.compareTo(gf1_d))
                    print(gf1_i.compareTo(gf1_i))
                    print(gf1_d.compareTo(gf1_i))

                    def gf1_String_1 = 'Hello'
                    def gf1_String_2 = 'amir'
                    if(gf1_String_1.equals(gf1_String_2)) {
                        echo "Content are same"
                    } else if (gf1_String_1 == gf1_String_2) {
                        echo "DataTypes are same"
                    } else {
                        echo"INVALID Data"
                    }
                    def gf1_i2 = "true"
                    def gf1_index2 = gf1_i2.indexOf('r')
                    Boolean gf1_status = Boolean.valueOf(gf1_i2)
                    print("SRV_status [ HEALTH ] => "+gf1_status+"\nindex of 'r' in ${gf1_i2} is ${gf1_index2}\n"+gf1_i2.plus(" mass"))

                    Integer gf1_number2 = 255
                    String gf1_HexDecimal = Integer.toString(gf1_number2,16)
                    String gf1_Binary = Integer.toString(gf1_number2,2)
                    String gf1_double_string = Double.toString(3.14)
                    println("Hex : ${gf1_HexDecimal} , Bin : ${gf1_Binary} , DoubleSTR : ${gf1_double_string}")

                    def gf1_range = 1..4
                    for(int gf1_player in gf1_range) {
                        print "hello player number ${gf1_player}"
                        println(gf1_range.get(3))
                        println(gf1_range.contains(4))
                    }                    
                }
            }
        }
        stage('Groovy_File_2') {
            steps {
                script {
                    def gf2_list = ['apple', 'banana']
                    gf2_list.add('cherry')
                    println gf2_list                       // [apple, banana, cherry]

                    // add at index — List.add(int index, E element)
                    gf2_list.add(1, 'apricot')
                    println gf2_list                       // [apple, apricot, banana, cherry]

                    // Chaining returns boolean, so this DOESN'T chain like << does
                    println gf2_list.add('date')           // true

                    // Compare with << operator (returns the list itself — chainable)
                    gf2_list << 'elderberry' << 'fig'
                    println gf2_list

                    def gf2_fruits = ['apple', 'banana', 'cherry']

                    // Basic iteration
                    gf2_fruits.each { fruit ->
                        println fruit
                    }
                    // apple
                    // banana
                    // cherry

                    // Implicit 'it' parameter
                    gf2_fruits.each { println it.toUpperCase() }
                    // APPLE
                    // BANANA
                    // CHERRY

                    // Two-arg form: (element, index) — actually equivalent to eachWithIndex
                    gf2_fruits.eachWithIndex { f, i -> println "$i -> $f" }

                    // each returns the original list
                    def gf2_result = gf2_fruits.each { }
                    println gf2_result == gf2_fruits           // true

                    def gf2_fruits2 = ['apple', 'banana', 'cherry']

                    gf2_fruits2.eachWithIndex { fruit, index ->
                        println "$index: $fruit"
                    }
                    // 0: apple
                    // 1: banana
                    // 2: cherry

                    // Build an indexed map
                    def gf2_indexed = [:]
                    gf2_fruits2.eachWithIndex { f, i -> gf2_indexed[f] = i }
                    println gf2_indexed                    // [apple:0, banana:1, cherry:2]

                    // Convert to numbered strings
                    def gf2_numbered = []
                    gf2_fruits2.eachWithIndex { f, i -> gf2_numbered << "${i + 1}. $f" }
                    println gf2_numbered                   // [1. apple, 2. banana, 3. cherry]

                    def gf2_numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

                    // --- Filter with a Closure ---
                    def gf2_evens = gf2_numbers.grep { it % 2 == 0 }
                    println gf2_evens                      // [2, 4, 6, 8, 10]

                    def gf2_big = gf2_numbers.grep { it > 5 }
                    println gf2_big                        // [6, 7, 8, 9, 10]

                    // --- Filter with a Regex ---
                    def gf2_words = ['apple', 'banana', 'avocado', 'cherry', 'apricot']
                    def gf2_aWords = gf2_words.grep(~/^a/)     // regex literal
                    println gf2_aWords                     // [apple, avocado, apricot]

                    def gf2_aWords2 = gf2_words.grep(~/an/)    // contains "an"
                    println gf2_aWords2                    // [banana]

                    // --- Filter by Class ---
                    def gf2_mixed = [1, 'two', 3.0, 'four', 5L, true]
                    def gf2_strings = gf2_mixed.grep(String)
                    println gf2_strings                    // [two, four]

                    def gf2_ints = gf2_mixed.grep(Integer)
                    println gf2_ints                       // [1]

                    def gf2_numbersOnly = gf2_mixed.grep(Number)
                    println gf2_numbersOnly                // [1, 3.0, 5]

                    // --- Filter by Range ---
                    def gf2_inRange = gf2_numbers.grep(3..6)
                    println gf2_inRange                    // [3, 4, 5, 6]

                    // --- Filter by Collection membership ---
                    def gf2_allowed = ['apple', 'cherry']
                    def gf2_picked = gf2_words.grep(gf2_allowed)
                    println gf2_picked                     // [apple, cherry]
                }
            }
        }
        stage('Groovy_File_3') {
            steps {
                script {
                    // ============================================================
                    //  GROOVY COLLECTION METHODS — FULL CODE SHEET
                    //  each / eachWithIndex / every / values
                    //  Every assertion here passes. Run with: groovy Sheet.groovy
                    // ============================================================
                    
                    println '=' * 60
                    println '1. each(Closure)'
                    println '=' * 60
                    
                    def fruits = ['apple', 'banana', 'cherry']
                    
                    // 1a. Basic block form
                    fruits.each { fruit ->
                        println fruit
                    }
                    // apple
                    // banana
                    // cherry
                    
                    // 1b. Implicit 'it'
                    fruits.each { println it.toUpperCase() }
                    // APPLE
                    // BANANA
                    // CHERRY
                    
                    // 1c. each returns the ORIGINAL list (same reference)
                    def eachResult = fruits.each { }
                    assert eachResult == fruits
                    assert eachResult.is(fruits)          // same reference
                    
                    // 1d. each on a Map — closure gets (key, value)
                    def mapA = [a: 1, b: 2, c: 3]
                    mapA.each { key, value ->
                        println "$key = $value"
                    }
                    // a = 1 / b = 2 / c = 3
                    
                    // 1e. each on a Map — single-arg form gets Map.Entry
                    mapA.each { entry ->
                        println "${entry.key}:${entry.value}"
                    }
                    // a:1 / b:2 / c:3
                    
                    // 1f. each on a Range
                    (1..4).each { println "player ${it}" }
                    // player 1 .. player 4
                    
                    // 1g. each on a String — iterates characters
                    'abc'.each { println it }
                    // a / b / c
                    
                    // 1h. GOTCHA: each does NOT transform
                    def notDoubled = [1, 2, 3].each { it * 2 }
                    assert notDoubled == [1, 2, 3]        // unchanged
                    
                    def reallyDoubled = [1, 2, 3].collect { it * 2 }
                    assert reallyDoubled == [2, 4, 6]     // use collect() to transform
                    
                    println '✅ each section done\n'
                    
                    
                    println '=' * 60
                    println '2. eachWithIndex(Closure)'
                    println '=' * 60
                    
                    def fruits2 = ['apple', 'banana', 'cherry']
                    
                    // 2a. Basic indexed iteration
                    fruits2.eachWithIndex { fruit, i ->
                        println "$i: $fruit"
                    }
                    // 0: apple / 1: banana / 2: cherry
                    
                    // 2b. Build an indexed map
                    def indexed = [:]
                    fruits2.eachWithIndex { f, i -> indexed[f] = i }
                    assert indexed == [apple: 0, banana: 1, cherry: 2]
                    
                    // 2c. Build numbered strings
                    def numbered = []
                    fruits2.eachWithIndex { f, i -> numbered << "${i + 1}. $f" }
                    assert numbered == ['1. apple', '2. banana', '3. cherry']
                    
                    // 2d. On a Range
                    def letters = []
                    ('a'..'d').eachWithIndex { ch, i ->
                        letters << "${i+1}->${ch}"
                    }
                    assert letters == ['1->a', '2->b', '3->c', '4->d']
                    
                    // 2e. each with two params also works (same as eachWithIndex)
                    def viaEach = []
                    ['x', 'y'].each { e, i -> viaEach << "$i=$e" }
                    assert viaEach == ['0=x', '1=y']
                    
                    def viaEachWithIndex = []
                    ['x', 'y'].eachWithIndex { e, i -> viaEachWithIndex << "$i=$e" }
                    assert viaEach == viaEachWithIndex
                    
                    // 2f. GOTCHA: eachWithIndex also returns the original collection
                    def r = ['a', 'b'].eachWithIndex { e, i -> }
                    assert r == ['a', 'b']
                    
                    println '✅ eachWithIndex section done\n'
                    
                    
                    println '=' * 60
                    println '3. every(Closure predicate)'
                    println '=' * 60
                    
                    def nums = [2, 4, 6, 8]
                    
                    // 3a. All true
                    assert nums.every { it % 2 == 0 }
                    
                    // 3b. One fails
                    assert !nums.every { it > 5 }
                    
                    // 3c. Short-circuits on first failure
                    def visited = []
                    def result = [1, 2, 3, 4].every { n ->
                        visited << n
                        n < 3
                    }
                    assert result == false
                    assert visited == [1, 2, 3]           // 4 never visited
                    
                    // 3d. Empty collection → vacuously true
                    assert [].every { false }
                    assert [].every { it > 0 }
                    
                    // 3e. On a Map — (key, value)
                    def scores = [alice: 90, bob: 85, carol: 95]
                    assert scores.every { k, v -> v >= 80 }
                    assert !scores.every { k, v -> v >= 90 }
                    
                    // 3f. On a Map — single-arg Map.Entry
                    assert scores.every { e -> e.value >= 80 }
                    
                    // 3g. On a Range
                    assert (1..10).every { it > 0 }
                    assert !(1..10).every { it < 5 }
                    
                    // 3h. On a String — iterates chars
                    assert 'abc'.every { it instanceof Character }
                    assert !'a1b2'.every { Character.isLetter(it) }
                    
                    // 3i. Real-world patterns
                    def fields = [name: 'alice', email: 'a@b.com', age: 30]
                    assert fields.every { k, v -> v != null && v != '' }
                    
                    assert [10, 20, 30].every { it in 0..100 }
                    
                    // 3j. Related: any / none / find / findAll
                    def smallNums = [1, 2, 3, 4]
                    assert  smallNums.every { it > 0 }       // ALL
                    assert  smallNums.any   { it > 3 }       // AT LEAST ONE
                    assert  smallNums.none  { it > 10 }      // NONE
                    assert  smallNums.find  { it > 2 } == 3  // FIRST match
                    assert  smallNums.findAll { it % 2 == 0 } == [2, 4]
                    
                    println '✅ every section done\n'
                    
                    
                    println '=' * 60
                    println '4. values()  (Map only)'
                    println '=' * 60
                    
                    def m = [a: 1, b: 2, c: 3]
                    
                    // 4a. Returns a Collection (order preserved in LinkedHashMap)
                    def vals = m.values()
                    assert vals == [1, 2, 3]
                    assert vals instanceof Collection
                    
                    // 4b. Collection methods work
                    assert m.values().sum()               == 6
                    assert m.values().max()               == 3
                    assert m.values().min()               == 1
                    assert m.values().sort()              == [1, 2, 3]
                    assert m.values().findAll { it > 1 }  == [2, 3]
                    assert m.values().collect { it * 10 } == [10, 20, 30]
                    
                    // 4c. Convert to List explicitly for indexing
                    def scores2 = [alice: 90, bob: 85, carol: 95]
                    List<Integer> scoreList = scores2.values().toList()
                    assert scoreList == [90, 85, 95]
                    assert scoreList[0] == 90
                    
                    // 4d. Iteration
                    def printed = []
                    scores2.values().each { printed << it }
                    assert printed == [90, 85, 95]
                    
                    // 4e. Contains / average
                    assert scores2.values().contains(90)
                    assert scores2.values().sum() / scores2.size() == 90.0
                    
                    // 4f. Companion methods
                    assert m.keySet()             == (['a', 'b', 'c'] as Set)
                    assert m.values()             == [1, 2, 3]
                    assert m.entrySet().size()    == 3
                    
                    // 4g. Iterate entries via entrySet()
                    def pairs = []
                    m.entrySet().each { e -> pairs << "${e.key}->${e.value}" }
                    assert pairs == ['a->1', 'b->2', 'c->3']
                    
                    // 4h. values() is a LIVE VIEW
                    def liveMap = [a: 1, b: 2]
                    def view = liveMap.values()
                    assert view == [1, 2]
                    
                    liveMap.c = 3
                    assert view == [1, 2, 3]                  // view updated automatically
                    
                    // 4i. Snapshot with toList() to freeze it
                    def snapshot = liveMap.values().toList()
                    liveMap.d = 4
                    assert snapshot == [1, 2, 3]              // frozen
                    assert liveMap.values() == [1, 2, 3, 4]   // live view sees d
                    
                    println '✅ values section done\n'
                    
                    
                    println '=' * 60
                    println '5. COMBINED PIPELINE-STYLE EXAMPLE'
                    println '=' * 60
                    
                    def servers = [
                        [name: 'web1', status: 'UP',   cpu: 40],
                        [name: 'web2', status: 'UP',   cpu: 55],
                        [name: 'db1',  status: 'UP',   cpu: 70],
                    ]
                    
                    // All servers UP?
                    assert servers.every { it.status == 'UP' }
                    
                    // Any server over 60% CPU?
                    assert servers.any { it.cpu > 60 }
                    
                    // Which one?
                    def hot = servers.find { it.cpu > 60 }
                    assert hot.name == 'db1'
                    
                    // Server names
                    def names = servers.collect { it.name }
                    assert names == ['web1', 'web2', 'db1']
                    
                    // Index every server
                    servers.eachWithIndex { s, i ->
                        println "server[$i] ${s.name} -> ${s.status} (cpu ${s.cpu}%)"
                    }
                    
                    // Build a name->cpu map
                    def cpuMap = [:]
                    servers.each { s -> cpuMap[s.name] = s.cpu }
                    assert cpuMap == [web1: 40, web2: 55, db1: 70]
                    
                    // Values of the map
                    assert cpuMap.values().max() == 70
                    assert cpuMap.values().sum() == 165
                    
                    // Every CPU is under 80
                    assert cpuMap.values().every { it < 80 }
                    
                    println '✅ combined section done\n'
                    
                    
                    println '=' * 60
                    println 'ALL SECTIONS PASSED ✅'
                    println '=' * 60
                }
            }
        }
        stage('Groovy_File_4') {
            steps {
                script {
                    echo "WE ARE WORKING IN THE FILES !"
                    // *
                }
            }
        }
    }
    post {
        always {
            echo "PIPELINE Finished !"
            script {
                Date date = new Date();
                println('time : '+date.toString()) 
            }
        }
    }
}

// break , continue , count++

//class Rectangle {
//    def calculateArea(width, height) {
//        return width * height
//    }
//}
//
//def rectangle = new Rectangle()
//def area = rectangle.calculateArea(4, 6)
//println("Area: ${area}") // Output: Area: 24

lst = [
    [IP_ADD : 192.168.1.1 ,connection_Timeout : 4,GROUP : "Develop" ]
    [IP_ADD : 192.168.1.2 ,connection_Timeout : 3,GROUP : "Develop" ]
    [IP_ADD : 192.168.1.3 ,connection_Timeout : 4,GROUP : "Develop" ]
    [IP_ADD : 192.168.1.4 ,connection_Timeout : 5,GROUP : "Develop" ]
    [IP_ADD : 192.168.10.1 ,connection_Timeout : 4,GROUP : "DevOps" ]
    [IP_ADD : 192.168.10.2 ,connection_Timeout : 2,GROUP : "DevOps" ]
    [IP_ADD : 192.168.2.1 ,connection_Timeout : 6,GROUP : "Net" ]
    [IP_ADD : 192.168.2.2 ,connection_Timeout : 3,GROUP : "Net" ]
    [IP_ADD : 192.168.2.3 ,connection_Timeout : 7,GROUP : "Net" ]
]
Integer x = y = z = 0
def Choose_number = [] 
Choose_number = lst.collect { element,index -> 
    switch(element.GROUP) {
        case 'Develop':
            Choose_number << "${index++}.${element.GROUP}"
            x++
            def Group = ((Math.max(x,y,z) == x) && z > y || y > z) ? 'Develop' : ''
            def Range = (192.168.1.1..3)
        case 'Devops': 
            Choose_number << "${index++}.${element.GROUP}"
            y++
            def Group = ((Math.max(x,y,z) == y) && z > x || x > z) ? 'DevOps' : ''
            def Range = (192.168.10.1..2)
        case 'Net': 
            Choose_number << "${index++}.${element.GROUP}"
            z++
            def Group = ((Math.max(x,y,z) == z) && x > y || y > x) ? 'Net' : ''
            def Range = (192.168.2.1..3)
        default:
            echo "INVALID Group !"
            break
    }
} 
println(Choose_number)

//if(Math.max(x,y,z) == x) {
//    def Group = 'Develop'
//} else if(Math.max(x,y,z) == x) {
//    def Group = 'DevOps'
//} else {
//    def Group = 'Net'
//}

def Check(arg_1,arg_2) {
    Boolean Permission_1 = Boolean.valueOf(arg_1)    
    if(!Permission_1) {
        Allow_Permission.pop()
        echo "FAILED !"
        for(int index in arg_2) {
            def Retry_Connection = sh(script:"ping -c 4 ${index}" ,returnStatus: true)
            Allow_Permission[index] = (Retry_Connection == 0)
        }
        Boolean Final_exp = Allow_Permission.values.every { it }
        assert (Final_exp.toBoolean() == true)
        echo "Retry_Connection PASSED !"
    } else {
        echo "PASSED !"
    }
}

Date date_time = new Date(date_time)
Allow_Permission = [:]

lst.each { client ->
    Allow_Permission[client.IP_ADD] = client.connection_Timeout
    client.IP_ADD in Range
    client.GROUP == Group
}
println("List Completed - ${Allow_Permission} - time : "+date_time.toString())
Boolean Permission = Allow_Permission.values.every { it > 4 }
println("Permission Granted - ${Permission} - time : "+date_time.toString())

assert (Permission.toBoolean() == true)
def ip_adds = Allow_Permission.collect { ip_Token ->
    ip_adds << ip_Token
}
println("List Completed - ${ip_adds} - time : "+date_time.toString())
Check(1,ip_adds)
println("Retrying Connection -------- time : "+date_time.toString())



def list_1 = []
def list_2 = []
def lists = [list_1,list_2]
for(int i in (0..1)) {
    ['x','y'].eachWithIndex { element , index -> 
        lists[i] << "${element}:${index}"
    }
}
assert list_1 == list_2
println("success")

def indexed = [:]
def lst = []
['x','y'].eachWithIndex { element,index ->
   lst << "${index}:${element}"
   indexed[index] = element 
}
println(indexed)
println(lst)

for(int i;i<=1;i++) {
    indexed.eachWithIndex {
        //assert "${it.key}:${it.value}" == lst[i]
        println("new : ${it.key}:${it.value}")
        println("lst : "+lst[i])
        assert "${it.key}:${it.value}" == lst[i++]
    }
    println('')
    print('DONE !')
}


def indexed = [ 1:'x', 2:'y'].collect { element,index -> 
    "${index}:${element}"
}
