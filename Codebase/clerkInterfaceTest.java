//Test Driven Development

public class IssueBookTest {
    
     @Test(expected = NullPointerException.class)
    public final void whenNullObjectIsUsedExceptionIsThrown() {
        Member testMember = Library.instance().searchMembership(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public final void whenNonAlphaNumricMemberIDIsUsedThenExceptionIsThrown() {
        Member testMember = Library.instance().searchMembership("MKD");

    }

    @Test(expected = IllegalArgumentException.class)
    public final void whenEmptyStringIsUsedThenExceptionIsThrown() {
        Member testMember = Library.instance().searchMembership("");

    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenLowerCaseIsUsedThenExceptionsIsThrown(){
        Member testMember = Library.instance().searchMembership("m1");
    }

   @Test(expected=IllegalArgumentException.class)
   public final void whenEmptyStringIsUsedThenExceptionIsThrown(){
       Book testBook=Library.instance().issueBook("","M1");   
   }
   
   @Test(expected=NullPointerException.class)
   public final void whenNullObjectIsUsedExceptionIsThrown() {
       Book testBook=Library.instance().issueBook(null, "M1");
   }
  
   @Test(expected=NullPointerException.class)
   public final void whenReturnObjectIsUsedExceptionIsThrown() {
      
       Assert.assertEquals(null,Library.instance().issueBook("123", "M1") );
   }
   
}
