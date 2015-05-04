package demo.proj.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CalendarAdapter extends XmlAdapter
{

 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

@Override
public Calendar marshal(Object date) throws Exception {
	  Calendar calendar = Calendar.getInstance();
	  calendar.setTime(df.parse((String)date));
	  return calendar;
}

@Override
public String unmarshal(Object calendar) throws Exception {
	  return df.format(((Calendar)calendar).getTime());
}
}
