

class RecordEvents {
	public  static  void  main ( String  args [ ] )  {
		Recorder r1 = new Recorder (100 ,100 ,"Wombat Detection ");
		r1.recordEvent("10:53:4", 20);
		r1.recordEvent("10:zz", 20);
		r1.recordEvent("11:005", 20);
		r1.recordEvent("56:59", 10);
		r1.recordEvent("13:59", 10);
		r1.recordEvent("12:06", 10);
		r1.recordEvent("14:08", 11);
		r1.printEvents();
	}
}
