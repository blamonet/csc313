// Stack Class

public class Stack  { 

  public Stack (int initialSize) throws IllegalArgumentException
  {
    if (initialSize < 1)
      throw new IllegalArgumentException("Stack Constructor: initialSize("+initialSize+") < 1");

    stack = new Object[initialSize];
    top   = -1;
  }
  
  public Stack ()
  {
  	this(1);
  }
  
  public void makeEmpty ()
  {
  	    int i = 0;
    while(!isEmpty()) {
        stack[i] = null;
        i++;
  }
  }
  
  public void push (Object o)
  {
    if (stack.length == top+1)
        doubleLength();
        
    top++;
    stack[top] = o;        //or just stack[++top] = s;
  }

  public Object pop () throws IllegalStateException
  {
    if ( isEmpty() )
      throw new IllegalStateException("Stack pop: Stack is empty");
    
    Object answer = stack[top];
    stack[top] = null;  //?
    top--;
    return answer;
  }
    
  public Object peek () throws IllegalStateException
  {
    if ( isEmpty() )
      throw new IllegalStateException("Stack peek: Stack is empty");
    
    return stack[top];  
  }
  
  public boolean isEmpty ()
  {return top == -1;}

  public int getSize ()
  {return top+1;}
  
  private void doubleLength ()
  {
    Object[] temp = new Object[stack.length*2];
    for (int i=0; i<stack.length; i++)
      temp[i] = stack[i];
    stack = temp;
  }

  private Object[] stack;
  private int      top;
}




