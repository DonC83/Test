package quartz;

import java.util.Date;
import java.util.List;

/**
 * Date: 2012/06/22
 * <p/>
 * The source, with you may it be old master.
 */
public class Event {

   private String userId;
   private String context;
   private String eventType;
   private String frequency;
   private String timeAsGmt;
   private List<Date> excludedDays;
   private String jobType;
   private List<String> calendars;

   public Event(String userId, String eventType) {
      this(userId, eventType, null);
   }

   public Event(String userId, String eventType, String timeAsGmt) {
      this(userId, eventType, timeAsGmt, null);
   }

   public Event(String userId, String eventType, String timeAsGmt, List<Date> excludedDays) {
      this.userId = userId;
      this.eventType = eventType;
      this.timeAsGmt = timeAsGmt;
      this.excludedDays = excludedDays;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getContext() {
      return context;
   }

   public void setContext(String context) {
      this.context = context;
   }

   public String getEventType() {
      return eventType;
   }

   public void setEventType(String eventType) {
      this.eventType = eventType;
   }

   public String getFrequency() {
      return frequency;
   }

   public void setFrequency(String frequency) {
      this.frequency = frequency;
   }

   public String getTimeAsGmt() {
      return timeAsGmt;
   }

   public void setTimeAsGmt(String timeAsGmt) {
      this.timeAsGmt = timeAsGmt;
   }

   public List<Date> getExcludedDays() {
      return excludedDays;
   }

   public void setExcludedDays(List<Date> excludedDays) {
      this.excludedDays = excludedDays;
   }

   public String getJobType() {
      return jobType;
   }

   public void setJobType(String jobType) {
      this.jobType = jobType;
   }

   public List<String> getCalendars() {
      return calendars;
   }

   public void setCalendars(List<String> calendars) {
      this.calendars = calendars;
   }
}
