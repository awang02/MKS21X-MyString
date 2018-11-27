public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;

  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++){
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index){
    if (index < 0 || index > this.length()){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public int length(){
    return data.length;
  }

  public CharSequence subSequence(int start, int end){
    if (start < 0 || end < 0 || start > end || end > this.length()){
      throw new IndexOutOfBoundsException();
    }
    String str = "";
    for (int i = start; i < data.length; i++){
      if (i < end){
        str += data[i];
      }
    }
    return str;
  }

  public String toString() {
    String print = "";
    for (int i = 0; i < data.length; i++){
      print += data[i];
    }
    return print;
  }

  public int compareTo(CharSequence o){
    if (data == null){
      throw new NullPointerException();
    }
    for (int i = 0; i < Math.min(this.length(),o.length()); i++){
      if (!(this.charAt(i) == o.charAt(i))){
        return this.charAt(i) - o.charAt(i);
      }
    }
    return this.length() - o.length();
  }
}
