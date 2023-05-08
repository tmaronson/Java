
public class Numbers {
  public static BigInteger lookAndSay(long n) {
		
		String str = Long.valueOf(n).toString();
		if(str.length() % 2 == 1) {
			return new BigInteger("-1");
		}
		String strReturn = "";
		for(int i = 0; i < str.length(); i += 2) {
			String ch = new Character(str.charAt(i)).toString();
			int repeat = Integer.parseInt(ch);
			for(int j = 0; j < repeat; j++) {
				strReturn = strReturn + str.charAt(i + 1);
			}
		}
		return new BigInteger(strReturn);
  }
}