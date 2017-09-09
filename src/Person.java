public class Person implements Comparable<Person>{
    int height, weight;
    public Person(int height, int weight){
        this.height = height;
        this.weight = weight;
    }
    public int compareTo(Person person){
        if(this.height < person.height)
            return -1;
        else if(this.height == person.height)
            return 0;
        else
            return 1;
    }
    public String toString(){
        return height + " " + weight;
    }
}
//    Person[] person = new Person[]{new Person(56,90), new Person(65,80), new Person(70,50), new Person(68,10)};
//        Arrays.sort(person);
//                System.out.print(Arrays.toString(person));
//                int minWeight = 0;
//                int res = 0;
//                for(Person p: person){
//                if(p.weight > minWeight)
//                ++res;
//                minWeight = p.weight;
//                }
//                System.out.print(res);