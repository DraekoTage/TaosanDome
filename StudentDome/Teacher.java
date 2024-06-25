import java.util.Scanner;

public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    //——教师类的相关方法——
    // 查找学生
    public Student findStudentByName(Student[] studentList,String name){
        for(int i=0;i<studentList.length;i++){
            if(name.equals(studentList[i].name)){
                return studentList[i];
            }
        }
        return null;
    }

    // 录入学生的分数
    public void inputScore(Student s){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生的数学成绩：");
        s.math = input.nextDouble();
        System.out.println("请输入学生的计算机成绩：");
        s.computer = input.nextDouble();
        s.num = s.math + s.computer;

    }

//排序算法
    public void sort(Student[] array){
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].num < array[j + 1].num) {
                    // 交换 array[j] 和 array[j+1]
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 查询所有学生成绩
    public void findAll(Student[] studentsList){
        // 降序排序
        sort(studentsList);
        for(Student s:studentsList){

            System.out.println(s.name + ":数学成绩:" + s.math + "计算机成绩：" + s.computer + "总成绩:" + s.num );
        }



    }
}
