package cn.wxic.mobileinternet.entiy;

public class ParkInfo {
   public String parkName;
   public String state;
   public String info;
public String getParkName() {
	return parkName;
}
public void setParkName(String parkName) {
	this.parkName = parkName;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
@Override
public String toString() {
	return "ParkInfo [parkName=" + parkName + ", state=" + state + ", info=" + info + "]";
}
   
   
   
   
}
