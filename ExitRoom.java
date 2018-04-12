public class ExitRoom
{
   public boolean isGuarded = true;
   public boolean isLocked = true;
   public boolean isChained = true;
   public boolean isPadlocked = true;
   
   public boolean readyToOpen()
   {
      if(!isGuarded && !isLocked && !isChained && !isPadlocked)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}