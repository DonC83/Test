package com.autochartist.web.aclite.client.model.relevance;

import java.io.Serializable;
import java.util.Date;

public class CPShortResult implements Serializable {
	@Override
	public String toString() {
		return "CPShortResult [resultuid=" + resultuid + ", relevant="
				+ relevant + ", notrelevantdatetime=" + notrelevantdatetime
				+ "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7847893307431550340L;

	public CPShortResult() {
		super();
	}

	public CPShortResult(long resultuid, int relevant,
			Date notrelevantdatetime) {
		super();
		this.resultuid = resultuid;
		this.relevant = relevant;
		this.notrelevantdatetime = notrelevantdatetime;
	}

	private long resultuid;
	private int relevant;
	private Date notrelevantdatetime;
	 
	public void setResultuid(long resultuid) {
		this.resultuid = resultuid;
	}
	
	public long getResultuid() {
		return resultuid;
	}

	public void setRelevant(int relevant) {
		this.relevant = relevant;
	}

	public int getRelevant() {
		return relevant;
	}

	public void setNotrelevantdatetime(
			Date notrelevantdatetime) {
		this.notrelevantdatetime = notrelevantdatetime;
	}

	public Date getNotrelevantdatetime() {
		return notrelevantdatetime;
	}
					 		 
}
