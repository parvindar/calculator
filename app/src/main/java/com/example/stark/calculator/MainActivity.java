package com.example.stark.calculator;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    Button addbtn,subtractbtn,multiplybtn,dividebtn,equalsbtn,onebtn,twobtn,threebtn,fourbtn,fivebtn,sixbtn,sevenbtn,eightbtn,ninebtn,zerobtn,dotbtn,cbutton,backbutton;
    TextView inputview,resultview;

  //  double[] value=new double[2];
 //   double value;
  //  int index=0;
    boolean calculated = false;
    boolean operated = false;
    char current_operation;
    String currentvalue;

    double result=0;
    static {
        System.loadLibrary("native-lib");
    }

    public MainActivity() {
     //   index = 0;
      //  currentvalue = new String();
        currentvalue="";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());

        addbtn=findViewById(R.id.addbtn);
        subtractbtn= findViewById(R.id.subtractbtn);
        multiplybtn= findViewById(R.id.multiplybtn);
        dividebtn= findViewById(R.id.dividebtn);
        equalsbtn= findViewById(R.id.equalsbtn);
        onebtn= findViewById(R.id.button1);
        twobtn= findViewById(R.id.button2);
        threebtn= findViewById(R.id.button3);
        fourbtn= findViewById(R.id.button4);
        fivebtn= findViewById(R.id.button5);
        sixbtn= findViewById(R.id.button6);
        sevenbtn= findViewById(R.id.button7);
        eightbtn= findViewById(R.id.button8);
        ninebtn= findViewById(R.id.button9);
        zerobtn= findViewById(R.id.button0);
        inputview=(EditText) findViewById(R.id.input);
        resultview= findViewById(R.id.result);
        dotbtn= findViewById(R.id.buttondot);
        cbutton= findViewById(R.id.buttonc);
        backbutton= findViewById(R.id.backspace);




        onebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"1");
    //            value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "1";

            }
        });
        twobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }


                inputview.setText(inputview.getText()+"2");
   //             value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "2";


            }
        });
        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"3");
      //          value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "3";


            }
        });
        fourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"4");
     //           value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "4";


            }
        });
        fivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"5");
    //            value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "5";


            }
        });
        sixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"6");
      //          value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "6";


            }
        });
        sevenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"7");
    //            value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "7";


            }
        });
        eightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"8");
   //             value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "8";


            }
        });
        ninebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"9");
   //             value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "9";


            }
        });
        zerobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                inputview.setText(inputview.getText()+"0");
      //          value=Double.parseDouble(inputview.getText().toString());
                currentvalue=currentvalue+ "0";


            }
        });
        dotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }


                if(!currentvalue.contains("."))
                {
                    inputview.setText((inputview.getText()+"."));
                    currentvalue=currentvalue+ ".";

                }



            }
        });

        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputview.setText("");
                resultview.setText("0");
                //value=0;
                operated=false;
                currentvalue="";
                result=0;

            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Double.isInfinite(result))
                {
                    reset();
                }

                if(inputview.length()>0&&currentvalue.length()>0)
                {
                    if(inputview.length()>3&&(inputview.getText().charAt(inputview.getText().length()-2)=='/'||inputview.getText().charAt(inputview.getText().length()-2)=='-'||inputview.getText().charAt(inputview.getText().length()-2)=='x'||inputview.getText().charAt(inputview.getText().length()-2)=='+'))
                    {
                        inputview.setText(inputview.getText().subSequence(0,inputview.getText().length()-3));

                    }
                    else {
                        inputview.setText(inputview.getText().subSequence(0, inputview.getText().length() - 1));
                        currentvalue=currentvalue.substring(0,currentvalue.length()-1);

                    }

                }
            }
        });



        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //calculate previous
                if(operated && currentvalue.length()>0)
                {
                    if(currentvalue.charAt(currentvalue.length()-1)=='.')
                        currentvalue=currentvalue+"0";

                    if(current_operation=='+')
                        result=result+Double.parseDouble(currentvalue.toString());
                    if(current_operation=='-')
                        result=result-Double.parseDouble(currentvalue.toString());
                    if(current_operation=='*')
                        result=result*Double.parseDouble(currentvalue.toString());
                    if(current_operation=='/')
                        result=result/Double.parseDouble(currentvalue.toString());


               //     inputview.setText(inputview.getText() + " + ");
                    resultview.setText(String.valueOf(result));
                    currentvalue="";


                }


                //set new current operator
                current_operation='+';
                if(!operated)
                {

                    if(inputview.getText().length()>0)
                    {
                        operated=true;
                        result=Double.parseDouble(inputview.getText().toString());
                        inputview.setText(inputview.getText() + " + ");
                        currentvalue="";
                    }

                }

                if(inputview.length()>2)
                    if(inputview.getText().charAt(inputview.getText().length()-2)=='/'||inputview.getText().charAt(inputview.getText().length()-2)=='-'||inputview.getText().charAt(inputview.getText().length()-2)=='x')
                    {
                        inputview.setText(inputview.getText().subSequence(0,inputview.getText().length()-3));
                    }

                if(inputview.length()>2) {
                    if(inputview.getText().charAt(inputview.getText().length()-2)!='+')
                        inputview.setText(inputview.getText()+" + ");
                }
                else if(inputview.getText().length()>0)
                    inputview.setText(inputview.getText()+ " + ");


            }
        });

        subtractbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculate previous
                if(operated&&currentvalue.length()>0)
                {
                    if(currentvalue.charAt(currentvalue.length()-1)=='.')
                        currentvalue=currentvalue+"0";

                    if(current_operation=='+')
                        result=result+Double.parseDouble(currentvalue.toString());
                    if(current_operation=='-')
                        result=result-Double.parseDouble(currentvalue.toString());
                    if(current_operation=='*')
                        result=result*Double.parseDouble(currentvalue.toString());
                    if(current_operation=='/')
                        result=result/Double.parseDouble(currentvalue.toString());


                //    inputview.setText(inputview.getText() + " - ");

                    resultview.setText(String.valueOf(result));
                    currentvalue="";


                }


                //set new current operator
                current_operation='-';
                if(!operated)
                {
                    if(inputview.getText().length()>0)
                    {
                        operated=true;
                        result=Double.parseDouble(inputview.getText().toString());
                        inputview.setText(inputview.getText() + " - ");
                        currentvalue="";
                    }
                }


                if(inputview.length()>2)
                    if(inputview.getText().charAt(inputview.getText().length()-2)=='+'||inputview.getText().charAt(inputview.getText().length()-2)=='/'||inputview.getText().charAt(inputview.getText().length()-2)=='x')
                    {
                        inputview.setText(inputview.getText().subSequence(0,inputview.getText().length()-3));
                    }
                if(inputview.length()>2) {
                    if(inputview.getText().charAt(inputview.getText().length()-2)!='-')
                        inputview.setText(inputview.getText()+" - ");
                }
                else if(inputview.getText().length()>0)
                    inputview.setText(inputview.getText()+ " - ");


            }
        });

        multiplybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculate previous
                if(operated&&currentvalue.length()>0)
                {
                    if(currentvalue.charAt(currentvalue.length()-1)=='.')
                        currentvalue=currentvalue+"0";

                    if(current_operation=='+')
                        result=result+Double.parseDouble(currentvalue.toString());
                    if(current_operation=='-')
                        result=result-Double.parseDouble(currentvalue.toString());
                    if(current_operation=='*')
                        result=result*Double.parseDouble(currentvalue.toString());
                    if(current_operation=='/')
                        result=result/Double.parseDouble(currentvalue.toString());

              //      inputview.setText(inputview.getText() + " x ");
                    resultview.setText(String.valueOf(result));
                    currentvalue="";


                }



                //set new current operator
                current_operation='*';
                if(!operated)
                {
                    if(inputview.getText().length()>0)
                    {
                        operated=true;
                        result=Double.parseDouble(inputview.getText().toString());
                        inputview.setText(inputview.getText() + " x ");
                        currentvalue="";
                    }

                }

                if(inputview.length()>2)
                    if(inputview.getText().charAt(inputview.getText().length()-2)=='+'||inputview.getText().charAt(inputview.getText().length()-2)=='-'||inputview.getText().charAt(inputview.getText().length()-2)=='/')
                    {
                        inputview.setText(inputview.getText().subSequence(0,inputview.getText().length()-3));
                    }
                if(inputview.length()>2) {
                    if(inputview.getText().charAt(inputview.getText().length()-2)!='x')
                        inputview.setText(inputview.getText()+" x ");
                }
                else if(inputview.getText().length()>0)
                    inputview.setText(inputview.getText()+ " x ");


            }
        });

        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculate previous
                if(operated&&currentvalue.length()>0)
                {
                    if(currentvalue.charAt(currentvalue.length()-1)=='.')
                        currentvalue=currentvalue+"0";

                    if(current_operation=='+')
                        result=result+Double.parseDouble(currentvalue.toString());
                    if(current_operation=='-')
                        result=result-Double.parseDouble(currentvalue.toString());
                    if(current_operation=='*')
                        result=result*Double.parseDouble(currentvalue.toString());
                    if(current_operation=='/')
                        result=result/Double.parseDouble(currentvalue.toString());



                    resultview.setText(String.valueOf(result));
                    currentvalue="";


                }


                if(!operated)
                {
                    if(inputview.getText().length()>0)
                    {
                        operated=true;
                        result=Double.parseDouble(inputview.getText().toString());
                        inputview.setText(inputview.getText() + " / ");
                        currentvalue="";
                    }

                }



                if(inputview.getText().length()>2)
                {

                    if(inputview.getText().charAt(inputview.getText().length()-2)=='+'||inputview.getText().charAt(inputview.getText().length()-2)=='-'||inputview.getText().charAt(inputview.getText().length()-2)=='x')
                    {
                        inputview.setText(inputview.getText().subSequence(0,inputview.getText().length()-3));
                    }



                }

                if(inputview.getText().length()>2)
                {
                    if(inputview.getText().charAt(inputview.getText().length()-2)!='/')
                    {
                        inputview.setText(inputview.getText()+ " / ");
                    }

                }
                else if(inputview.getText().length()>0)
                    inputview.setText(inputview.getText()+ " / ");






                //set new current operator
                current_operation='/';


            }
        });

        equalsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculate previous
                if(operated&&currentvalue.length()>0)
                {
                    if(currentvalue.charAt(currentvalue.length()-1)=='.')
                        currentvalue=currentvalue+"0";

                    if(current_operation=='+')
                        result=result+Double.parseDouble(currentvalue.toString());
                    if(current_operation=='-')
                        result=result-Double.parseDouble(currentvalue.toString());
                    if(current_operation=='*')
                        result=result*Double.parseDouble(currentvalue.toString());
                    if(current_operation=='/')
                        result=result/Double.parseDouble(currentvalue.toString());



                    resultview.setText(String.valueOf(result));
                    inputview.setText(resultview.getText());
                    currentvalue=inputview.getText().toString();
                 //   result=0;
                }

                //inputview.setText("");
                //current_operation='=';
                operated=false;

            }
        });











    }

    private void reset() {

        inputview.setText("");
        resultview.setText("0");
        //value=0;
        operated=false;
        currentvalue="";
        result=0;

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
