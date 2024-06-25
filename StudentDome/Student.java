public class Student extends Person{
    double math;
    double computer;

    // 总成绩
    double num;

    public Student() {

    }

    public Student(String name, int age, double math, double computer) {
        super(name, age);
        this.math = math;
        this.computer = computer;
        this.num = math + computer;
    }
    public Student(String name, int age) {
        super(name, age);
    }



    // 学生类的相关方法
    // 学生基本信息
    public void showInfo(){
        System.out.println("学生个人基本信息如下：");
        System.out.println("姓名:" + name + ",年龄：" + age);
    }

    // 学生成绩信息
    public void chenji(){
        System.out.println("学生个人基本信息如下：");
        double sum = math + computer;
        System.out.println("数学成绩:" + math + ",计算机成绩：" + computer + "总分：" + num);

    }

    // 根据姓名找学生
    public Student findStudentByName(Student[] studentList,String name){
        for(int i=0;i<studentList.length;i++){
            if(name.equals(studentList[i].name)){
                return studentList[i];
            }
        }
        return null;
    }
}
