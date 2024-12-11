package mistakes;

public class BridgeMethodInPolimorphismTypeErasure extends  BoundedTypeExample{

 public BridgeMethodInPolimorphismTypeErasure(Integer num){
     super(num);
 }


 //  Bridge method generated b compiler
  public void setObj(Object num){
     setObj((Integer)num);
  }

}
