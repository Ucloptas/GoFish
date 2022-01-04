/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

/**
 *
 * @author ethan
 */
public class card {
    public String suite;
    public int num;
    boolean taken = false;
    public card(String suite, int num){
        this.suite = suite;
        this.num = num;
    }
    public card(){
        boolean taken = true;
    }
    public String getSuite(){
        return suite;
    }
    public int getNum(){
        return num;
    }
    public void setSuite(String in){
        suite=in;
    }
    public void setNum(int in){
        num = in;
    }
    public String toString(){
        return (num +" of "+suite+" ");
    }
    public void toggle(){
        if(taken)
            taken=false;
        else
            taken=true;
    }
    public boolean getToggle(){
        return taken;
    }
}
