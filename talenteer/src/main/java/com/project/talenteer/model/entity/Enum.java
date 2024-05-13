package com.project.talenteer.model.entity;

public class Enum {

    public enum Cinsiyet {
        ERKEK,
        KADIN
    }

    public enum IsTuru {
        FULL_TIME,
        PART_TIME,
        FREELANCE,
        STAJ
    }
    
    public enum CalismaTuru {
        UZAKTAN,
        HIBRIT,
        OFIS
    }

    public enum Pozisyon {
        BACKEND_DEVELOPER_JAVA,
        BACKEND_DEVELOPER_C,
        BACKEND_DEVELOPER_CPLUS,
        BACKEND_DEVELOPER_PHP,
        FRONTEND_DEVELOPER_VUE,
        FRONTEND_DEVELOPER_TYPESCRIPT,
        FRONTEND_DEVELOPER_ANGULAR,
        FRONTEND_DEVELOPER_JAVASCRIPT,
        DATA_ANALYST,
        DATA_ENGINEER,
        GAME_DEVELOPER_UNITY,
        GAME_DEVELOPER_UNREALENGINE
    }

    public enum Ulke {
        ISTANBUL,
        ANKARA,
        IZMIR,
        TURKIYE_DIGER,
        AVRUPA,
        ABD
    }

    public enum Rapor {
        VAR,
        YOK
    }
    

}
