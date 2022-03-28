package com.breakoutedu.utility;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:${env}.properties"
})
public interface Environment extends Config {

    String browser();

    @Config.Key("user_url")
    String userUrl();

    @Config.Key("stud_url")
    String studUrl();

    String student1();
    String student2();
    String student3();
    String student4();
    String student5();

    @Config.Key("student1_classroom")
    String studClassr();

    String teacher1();
    String teacher2();
    String schoolAdmin1();
    String schoolAdmin2();
    String districtAdmin1();
    String districtAdmin2();


    /**
     *

     ##--------------PASSWORDS:
     teacherPassword=yuliiawork22
     studentPassword=yw22
     studentClassPsw=yuliiawork22

     image_path=/Users/yuliiarublenko/Desktop/breakouteduuuu.jpeg
     imageLarge_path=/Users/yuliiarublenko/Downloads/5DABF64C-CB8A-4C6A-946F-BB078360B11C.mov
     imageWrongType_path=/Users/yuliiarublenko/Downloads/IMG_8236.HEIC

     existing_gameTitle=existing game

     ##------CLASS CODES
     classCode=37XJD9

     */
}
