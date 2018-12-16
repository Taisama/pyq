package model;

public class Mood {
	private String headImg;
	private String uname;
	private String mood;
	public Mood(String headImg, String uname, String mood) {
		super();
		this.headImg = headImg;
		this.uname = uname;
		this.mood = mood;
	}
	
	public Mood() {
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}
	public String getMoodItem() {
		return "{\"headImg\":\""+this.getHeadImg()+"\",\"uname\":\""+this.getUname()+"\",\"mood\":\""+this.getMood()+"\"}";
	}
	
}
