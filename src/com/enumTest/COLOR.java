package com.enumTest;

public enum COLOR {

	RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),YELLOW(255,255,0),GREEN(0,255,0);  
    private COLOR(int rv,int gv,int bv){
     this.redValue=rv;  
     this.greenValue=gv;  
     this.blueValue=bv;  
    }  

    public String toString(){  //�����˸���Enum��toString()  
    	return super.toString()+"("+redValue+","+greenValue+","+blueValue+")";  
    }  

    private int redValue;
    private int greenValue;  
    private int blueValue;
	public int getRedValue() {
		return redValue;
	}

	public int getGreenValue() {
		return greenValue;
	}

	public int getBlueValue() {
		return blueValue;
	}
    
    
}
