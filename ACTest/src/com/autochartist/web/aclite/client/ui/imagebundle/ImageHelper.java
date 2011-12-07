package com.autochartist.web.aclite.client.ui.imagebundle;

import com.autochartist.web.aclite.client.constants.GlobalSettings;
import com.google.gwt.user.client.ui.Image;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ImageHelper implements Serializable {
	

	public Image getDirectionIcon(int direction, boolean complete, boolean easternStyle) {
		Image image = null;
		if (!easternStyle) {
			if (direction < 0) {
				if (complete) {
					image = new Image(ACLiteImageBundle.INSTANCE.getDownIcon());
				} else {
					image = new Image(ACLiteImageBundle.INSTANCE.getDownBlankIcon());
				}
			} else if (direction > 0) {
				if (complete) {
					image = new Image(ACLiteImageBundle.INSTANCE.getUpIcon());
				} else {
					image = new Image(ACLiteImageBundle.INSTANCE.getUpBlankIcon());
				}
			}
		} else {
			if (direction < 0) {
				if (complete) {
					image = new Image(ACLiteImageBundle.INSTANCE.getDownEastIcon());
				} else {
					image = new Image(ACLiteImageBundle.INSTANCE.getDownBlankIcon());
				}
			} else if (direction > 0) {
				if (complete) {
					image = new Image(ACLiteImageBundle.INSTANCE.getUpEastIcon());
				} else {
					image = new Image(ACLiteImageBundle.INSTANCE.getUpBlankIcon());
				}
			}
		}
		return image;
		
	}

    public String getDirectionIconString(int direction, boolean complete, boolean easternStyle) {
		String image = null;
		if (!easternStyle) {
			if (direction < 0) {
				if (complete) {
					image = "Down.PNG";
				} else {
					image = "downBlank.PNG";
				}
			} else if (direction > 0) {
				if (complete) {
					image = "Up.PNG";
				} else {
					image = "upBlank.PNG";
				}
			}
		} else {
			if (direction < 0) {
				if (complete) {
					image = "DownEast.PNG";
				} else {
					image = "downBlank.PNG";
				}
			} else if (direction > 0) {
				if (complete) {
					image = "UpEast.PNG";
				} else {
					image = "upBlank.PNG";
				}
			}
		}
		return image;

	}
	
	public Map<String, String> getDirectionIconUrlMap(boolean complete, boolean easternStyle) {		
		/*Map<String, String> iconMap = new HashMap<String, String>();
		iconMap.put("-1", getDirectionIcon(-1,complete).getUrl());
		iconMap.put("1", getDirectionIcon(1,complete).getUrl());		
		return iconMap;*/
		Map<String, String> iconMap = new HashMap<String, String>();
		if (!easternStyle) {
			if (complete) {
				iconMap.put("-1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/Down.PNG");
				iconMap.put("1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/Up.PNG");
			} else {
				iconMap.put("-1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/downBlank.PNG");
				iconMap.put("1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/upBlank.PNG");
			}
		} else {
			if (complete) {
				iconMap.put("-1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/DownEast.PNG");
				iconMap.put("1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/UpEast.PNG");
			} else {
				iconMap.put("-1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/downBlank.PNG");
				iconMap.put("1", GlobalSettings.CONTEXT_PREFIX
						+ "/icons/upBlank.PNG");
			}
		}
		return iconMap;
	}
	
	public Image getStrengthIcon(String colour, double strength) {
        Image image = null;
		if (colour.equals("Blue")) {
	        image = getBlueStrengthImage(strength);
		} else if (colour.equals("Green")) {
	        image = getGreenStrengthImage(strength);
		} else if (colour.equals("Gold")) {
	        image = getGoldStrengthImage(strength);
		} else if (colour.equals("Orange")) {
	        image = getOrangeStrengthImage(strength);
		} else if (colour.equals("Brown")) {
	        image = getBrownStrengthImage(strength);
		} else if (colour.equals("Purple")) {
	        image = getPurpleStrengthImage(strength);
		}
        return image;        
    }

    public String getStrenghtIconString(String colour, double strength) {
        String image = null;
        if (colour.equals("Blue")) {
            image = getBlueStrengthImageString(strength);
        }
		return image;
    }
	
	public Map<String, String> getStrengthIconUrlMap(String colour) {		
		Map<String, String> iconMap = new HashMap<String, String>();
		iconMap.put("0.1", getStrengthIcon(colour, 0.1).getUrl());
		iconMap.put("0.2", getStrengthIcon(colour, 0.2).getUrl());
		iconMap.put("0.3", getStrengthIcon(colour, 0.3).getUrl());
		iconMap.put("0.4", getStrengthIcon(colour, 0.4).getUrl());
		iconMap.put("0.5", getStrengthIcon(colour, 0.5).getUrl());
		iconMap.put("0.6", getStrengthIcon(colour, 0.6).getUrl());
		iconMap.put("0.7", getStrengthIcon(colour, 0.7).getUrl());
		iconMap.put("0.8", getStrengthIcon(colour, 0.8).getUrl());
		iconMap.put("0.9", getStrengthIcon(colour, 0.9).getUrl());
		iconMap.put("1.0", getStrengthIcon(colour, 1.0).getUrl());
		return iconMap;
	}
	
	public Map<String, String> getBlueStrengthIconUrlMap() {		
		Map<String, String> iconMap = new HashMap<String, String>();
		iconMap.put("0.1", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue1.PNG");
		iconMap.put("0.2", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue2.PNG");
		iconMap.put("0.3", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue3.PNG");
		iconMap.put("0.4", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue4.PNG");
		iconMap.put("0.5", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue5.PNG");
		iconMap.put("0.6", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue6.PNG");
		iconMap.put("0.7", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue7.PNG");
		iconMap.put("0.8", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue8.PNG");
		iconMap.put("0.9", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue9.PNG");
		iconMap.put("1.0", GlobalSettings.CONTEXT_PREFIX + "/icons/Blue10.PNG");
		return iconMap;
	}
	
	public Image getNewResultIcon() {
		return new Image(ACLiteImageBundle.INSTANCE.getNewResultIcon());
	}
	
	public Map<String, String> getNewResultIconUrlMap() {		
		/*
		Map<String, String> iconMap = new HashMap<String, String>();
		iconMap.put("true", getNewResultIcon().getUrl());
		//iconMap.put("false", "#");
		*/
		Map<String, String> iconMap = new HashMap<String, String>();
		iconMap.put("true", GlobalSettings.CONTEXT_PREFIX + "/icons/newresult.png");
		return iconMap;
	}
	
	

	private Image getBlueStrengthImage(double strength) {
		Image image;
		if(strength <= 0.0)
		    image = new Image(ACLiteImageBundle.INSTANCE.getSpacerIcon());
		else if(strength <= 0.149)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthOne());
		else if(strength <= 0.249)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthTwo());
		else if(strength <= 0.349)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthThree());
		else if(strength <= 0.449)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthFour());
		else if(strength <= 0.549)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthFive());
		else if(strength <= 0.649)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthSix());
		else if(strength <= 0.749)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthSeven());
		else if(strength <= 0.849)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthEight());
		else if(strength <= 0.949)
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthNine());
		else 
			image = new Image(ACLiteImageBundle.INSTANCE.getBlueStrengthTen());
		return image;
	}

    private String getBlueStrengthImageString(double strength) {
		String image;
		if(strength <= 0.0)
		    image = GlobalSettings.CONTEXT_PREFIX + "/icons/spacer.gif";
		else if(strength <= 0.149)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue1.PNG";
		else if(strength <= 0.249)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue2.PNG";
		else if(strength <= 0.349)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue3.PNG";
		else if(strength <= 0.449)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue4.PNG";
		else if(strength <= 0.549)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue5.PNG";
		else if(strength <= 0.649)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue6.PNG";
		else if(strength <= 0.749)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue7.PNG";
		else if(strength <= 0.849)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue8.PNG";
		else if(strength <= 0.949)
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue9.PNG";
		else
			image = GlobalSettings.CONTEXT_PREFIX + "/icons/Blue10.PNG";
		return image;
	}

	
	private Image getGreenStrengthImage(double strength) {
		Image image;
		if(strength <= 0.0)
		    image = new Image(ACLiteImageBundle.INSTANCE.getSpacerIcon());
		else if(strength <= 0.149)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthOne());
		else if(strength <= 0.249)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthTwo());
		else if(strength <= 0.349)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthThree());
		else if(strength <= 0.449)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthFour());
		else if(strength <= 0.549)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthFive());
		else if(strength <= 0.649)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthSix());
		else if(strength <= 0.749)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthSeven());
		else if(strength <= 0.849)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthEight());
		else if(strength <= 0.949)
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthNine());
		else 
			image = new Image(ACLiteImageBundle.INSTANCE.getGreenStrengthTen());
		return image;
	}
	
	private Image getGoldStrengthImage(double strength) {
		Image image;
		if(strength <= 0.0)
		    image = new Image(ACLiteImageBundle.INSTANCE.getSpacerIcon());
		else if(strength <= 0.149)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthOne());
		else if(strength <= 0.249)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthTwo());
		else if(strength <= 0.349)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthThree());
		else if(strength <= 0.449)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthFour());
		else if(strength <= 0.549)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthFive());
		else if(strength <= 0.649)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthSix());
		else if(strength <= 0.749)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthSeven());
		else if(strength <= 0.849)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthEight());
		else if(strength <= 0.949)
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthNine());
		else 
			image = new Image(ACLiteImageBundle.INSTANCE.getGoldStrengthTen());
		return image;
	}
	
	private Image getOrangeStrengthImage(double strength) {
		Image image;
		if(strength <= 0.0)
		    image = new Image(ACLiteImageBundle.INSTANCE.getSpacerIcon());
		else if(strength <= 0.149)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthOne());
		else if(strength <= 0.249)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthTwo());
		else if(strength <= 0.349)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthThree());
		else if(strength <= 0.449)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthFour());
		else if(strength <= 0.549)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthFive());
		else if(strength <= 0.649)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthSix());
		else if(strength <= 0.749)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthSeven());
		else if(strength <= 0.849)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthEight());
		else if(strength <= 0.949)
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthNine());
		else 
			image = new Image(ACLiteImageBundle.INSTANCE.getOrangeStrengthTen());
		return image;
	}
	
	private Image getBrownStrengthImage(double strength) {
		Image image;
		if(strength <= 0.0)
		    image = new Image(ACLiteImageBundle.INSTANCE.getSpacerIcon());
		else if(strength <= 0.149)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthOne());
		else if(strength <= 0.249)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthTwo());
		else if(strength <= 0.349)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthThree());
		else if(strength <= 0.449)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthFour());
		else if(strength <= 0.549)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthFive());
		else if(strength <= 0.649)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthSix());
		else if(strength <= 0.749)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthSeven());
		else if(strength <= 0.849)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthEight());
		else if(strength <= 0.949)
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthNine());
		else 
			image = new Image(ACLiteImageBundle.INSTANCE.getBrownStrengthTen());
		return image;
	}
	
	private Image getPurpleStrengthImage(double strength) {
		Image image;
		if(strength <= 0.0)
		    image = new Image(ACLiteImageBundle.INSTANCE.getSpacerIcon());
		else if(strength <= 0.149)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthOne());
		else if(strength <= 0.249)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthTwo());
		else if(strength <= 0.349)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthThree());
		else if(strength <= 0.449)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthFour());
		else if(strength <= 0.549)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthFive());
		else if(strength <= 0.649)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthSix());
		else if(strength <= 0.749)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthSeven());
		else if(strength <= 0.849)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthEight());
		else if(strength <= 0.949)
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthNine());
		else 
			image = new Image(ACLiteImageBundle.INSTANCE.getPurpleStrengthTen());
		return image;
	}

    public Image getSpacerImage(){
       Image image=new Image(ACLiteImageBundle.INSTANCE.getSpacerIcon());
        return image;
    }
	
}
