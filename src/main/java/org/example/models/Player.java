package org.example.models;

public class Player {

    private final String name ;
    private final Integer id;
    private Integer curPos ;
    public Player(String name, Integer id, Integer curPos) {
        this.name = name ;
        this.id = id ;
        this.curPos = curPos ;
    }

    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }
    public Integer getCurPos() {
        return curPos;
    }
    public void setCurPos(Integer curPos) {
        this.curPos = curPos;
    }
}
