package com.megetood.structure.hashcode;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/09 12:58
 */
public class Student {
    int grade;
    int cls; // 班级
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 31;

        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Student anOther = (Student) obj;
        return this.grade == anOther.grade &&
                this.cls == anOther.cls &&
                this.firstName.toLowerCase().equals(anOther.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(anOther.lastName.toLowerCase());
    }
}
