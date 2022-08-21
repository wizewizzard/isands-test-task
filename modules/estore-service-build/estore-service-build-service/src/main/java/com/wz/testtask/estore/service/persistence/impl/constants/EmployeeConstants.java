package com.wz.testtask.estore.service.persistence.impl.constants;

public class EmployeeConstants {
    public enum GENDER{UNKNOWN(1), MALE(2), FEMALE(3), OTHER(4);
        private final int value;
        
        GENDER(int value){
            this.value = value;
        }
    
        public int getValue() {
            return value;
        }
    }
}
