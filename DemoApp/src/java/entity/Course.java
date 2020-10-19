/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Course {
    private String idCourse;
    private String nameCourse;
    private String timeStart;
    private String timeEnd;
    private String idTopic;
    private String idCategory;
    private String idTeacher;

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Course() {
    }

    public Course(String idCourse, String nameCourse, String timeStart, String timeEnd, String idTopic, String idCategory, String idTeacher) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.idTopic = idTopic;
        this.idCategory = idCategory;
        this.idTeacher = idTeacher;
    }
    
    
}
