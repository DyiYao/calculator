package org.crazyit.ui;

//import java.util.Arrays;
//import org.crazyit.ui.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
/*说明*/

public class GridLayoutTest extends Activity implements View.OnClickListener{

	private EditText rsText;//用来显示输入的字符和数字
	
	private String OperateSum="";//字符串保留输入的符号和数字
	private char Operator;//用来记录运算符号
	private double num1=0,num2=0,sum=0;//num1、num2记录输入的数字，sum运算结果
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();//按钮和事件初始化
	}
	private void initView()
	{
		rsText = (EditText)findViewById(R.id.rsText);
		rsText.setCursorVisible(false);//不设置光标移动
		//功能按钮
		Button btnDel = (Button)findViewById(R.id.delete);//清除
		Button btnPlu = (Button)findViewById(R.id.plus);  //+
		Button btnMin = (Button)findViewById(R.id.minus); //-
		Button btnMul = (Button)findViewById(R.id.multiply); //x
		Button btnDiv = (Button)findViewById(R.id.division);  //÷
		Button btnEqu = (Button)findViewById(R.id.equ);  //=
		Button btnTono = (Button)findViewById(R.id.tonone); //C
		
		//数字按钮
		Button num0 = (Button)findViewById(R.id.num0);
		Button num1 = (Button)findViewById(R.id.num1);
		Button num2 = (Button)findViewById(R.id.num2);
		Button num3 = (Button)findViewById(R.id.num3);
		Button num4 = (Button)findViewById(R.id.num4);
		Button num5 = (Button)findViewById(R.id.num5);
		Button num6 = (Button)findViewById(R.id.num6);
		Button num7 = (Button)findViewById(R.id.num7);
		Button num8 = (Button)findViewById(R.id.num8);
		Button num9 = (Button)findViewById(R.id.num9);
		Button dot = (Button)findViewById(R.id.dot);
		
		//listener
		btnTono.setOnClickListener(this);//添加按钮事件
		btnDel.setOnClickListener(this);
		btnPlu.setOnClickListener(this);
		btnMin.setOnClickListener(this);
		btnMul.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnEqu.setOnClickListener(this);
		  num0.setOnClickListener(this);
		  num1.setOnClickListener(this);
		  num2.setOnClickListener(this);
		  num3.setOnClickListener(this);
		  num4.setOnClickListener(this);
		  num5.setOnClickListener(this);
		  num6.setOnClickListener(this);
		  num7.setOnClickListener(this);
		  num8.setOnClickListener(this);
		  num9.setOnClickListener(this);
		  dot.setOnClickListener(this);
		  rsText.setOnClickListener(this);
	}
public void onClick(View v){
	switch(v.getId()){
	//num 数字按钮
	  case R.id.num0:   //记录输入数字0  
		OperateSum=AddSum('0');//把数字添加到OperatsSum
		rsText.setText(OperateSum);//把输入的数字显示在rsText
		break;
	  case R.id.num1:   
			OperateSum=AddSum('1');
			rsText.setText(OperateSum);
			break;
	  case R.id.num2:   
			OperateSum=AddSum('2');
			rsText.setText(OperateSum);
			break;
	  case R.id.num3:   
			OperateSum=AddSum('3');
			rsText.setText(OperateSum);
			break;
	  case R.id.num4:   
			OperateSum=AddSum('4');
			rsText.setText(OperateSum);
			break;
	  case R.id.num5:   
			OperateSum=AddSum('5');
			rsText.setText(OperateSum);
			break;
	  case R.id.num6:   
			OperateSum=AddSum('6');
			rsText.setText(OperateSum);
			break;
	  case R.id.num7:   
			OperateSum=AddSum('7');
			rsText.setText(OperateSum);
			break;
	  case R.id.num8:   
			OperateSum=AddSum('8');
			rsText.setText(OperateSum);
			break;
	  case R.id.num9:   
			OperateSum=AddSum('9');
			rsText.setText(OperateSum);
			break;
	  case R.id.dot:   
			OperateSum=AddSum('.');
			rsText.setText(OperateSum);
			break;
	//fun 功能按钮
	  case R.id.plus:   
			OperateSum=AddSum('+');
			Operator='+';
			rsText.setText(OperateSum);
			break;
	  case R.id.minus:   
			OperateSum=AddSum('-');
			Operator='-';
			rsText.setText(OperateSum);
			break;
	  case R.id.multiply:   
			OperateSum=AddSum('x');
			Operator='x';
			rsText.setText(OperateSum);
			break;
	  case R.id.division:   
			OperateSum=AddSum('÷');
			Operator='÷';
			rsText.setText(OperateSum);
			break;
	  case R.id.delete:   //清除整个显示框
			OperateSum="";
		    num1=0;
		    num2=0;
		    sum=0;
		    Operator=' ';
			rsText.setText(OperateSum);
			break;
	  case R.id.tonone:   //退一位C
		  if(OperateSum.length()>=1)//当至少有一个符号
			{
				OperateSum=OperateSum.substring(0,OperateSum.length()-1);
			}
			rsText.setText(OperateSum);
			break;
	  case R.id.equ:
          if(CheckInput(OperateSum))//当输入的数字和运算符都正确，才进行计算
          {
              OperateSum=OperateSum+"="+String.valueOf(equals(OperateSum)); //把整个算式保留
              rsText.setText(OperateSum);//显示数字运算符和结果
              OperateSum=String.valueOf(sum); //保存运算结果，以便再直接输入一个运算符和一个数字进行下一次运算
          }
          else                        //输入不合理弹出警告
          {
              Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
          }
          break;
      default:
          break;
	}
}

public String AddSum(char c)//添加并记录一个输入的数字或符号
{
    OperateSum=OperateSum+String.valueOf(c);//String.valueOf(c)将 char 变量 c 转换成字符串
    return OperateSum;
}	
public boolean CheckInput(String OperateSum)    //这个方法用来检查用户输入的数字是否合理
{
    if(OperateSum.length()<=2)//至少要分别输入了一个数字和一个运算符和一个数字，输入长度<=2肯定不合理
    {
        return false;
    }
    if(OperateSum.indexOf(Operator,1)==-1)     //如果没有输入运算符，返回-1证明从1开始位置没有找到运算符Operator
    {
        return false;
    }

    if(OperateSum.endsWith(String.valueOf(Operator)))       //是否有在输入运算符之后加入数字？验证OperateSum的后缀是不是为Operator，是的话报错
    {
        return false;
    }
    return true;
}
public double equals(String OperateSum)         //计算结果
{
    int indexOfOperator=0;
    indexOfOperator=OperateSum.indexOf(Operator,1);         //计算运算符在从输入的OperateSum字符串里的位置，以此后面可以得到两个运算对象
    if(OperateSum.length()>=3)
    {
        num1=Double.parseDouble(OperateSum.substring(0, indexOfOperator));  //从输入的OperateSum字符串里得到第一个运算数
        num2=Double.parseDouble(OperateSum.substring(indexOfOperator + 1, OperateSum.length()));    //从输入的OperateSum字符串里得到第二个运算数
    }
    switch (Operator)       //根据运算符进行计算
    {
        case '+':           //加法运算
            sum=num1+num2;
            break;
        case '-':           //减法运算
            sum=num1-num2;
            break;
        case 'x':           //乘法运算
            sum=num1*num2;
            break;
        case '÷':           //除法运算
            if(num2!=0)     //除数不应该为0
            {
                sum=num1/num2;
            }
            else
            {
                sum=0;
                Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();//若除数是0，弹出警告
            }
            break;
        default:
            break;
    }
    return sum;         //返回结果
}
}

