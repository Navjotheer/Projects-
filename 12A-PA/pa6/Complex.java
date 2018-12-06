//Complex.java
//Navjot Heer
//nsheer
//pa6
//Represents complex numbers as a pair of double values

//-----------------------------------------------------------------------------
// Complex.java
// Represents complex numbers as a pair of doubles
//
// pa6
// Fill in the function definitions below. See class notes, or the project 
// description for the definitions of the complex arithmetic operations.
//-----------------------------------------------------------------------------

class Complex {

   //--------------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
   private double re;
   private double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }

   Complex(String str){
      double[] C = parseComplex(str);
      this.re = C[0];
      this.im = C[1];

  
   }

   //—--------------------------------------------------------------------------
   // Private methods
   //---------------------------------------------------------------------------

   //parses a complex number string as an array

   static double[] parseComplex(String str){
      double[] part = new double[2];
      String s = str.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP =  "\\s*[+-]\\s*";
      String I =   "i";
      String OR =  "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;
      
      if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      return part;
   }

   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex

   Complex copy(){
      return new Complex(this.re, this.im);
   }
   
   // add()
   // Return a new Complex representing the sum this plus z.

   Complex add(Complex z){
      return new Complex(this.re + z.re, this.im + z.im);
   }
   
   // negate()
   // Return a new Complex representing the negative of this.

   Complex negate(){
      return new Complex(-this.re, -this.im);
   }

   // sub()
   // Return a new Complex representing the difference this minus z.

   Complex sub(Complex z){
      return new Complex(this.re - z.re, this.im - z.im);
   }

   // mult()
   // Return a new Complex representing the product this times z.

   Complex mult(Complex z){
      return new Complex((this.re * z.re) - (this.im * z.im), (this.re * z.im) + (this.im * z.re));
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).

   Complex recip(){
      double a, b;

      if(this.equals(Complex.ZERO)){ 
        throw new ArithmeticException("/ by 0");
      }

      a = this.re * this.re; 
      b = this.im * this.im;
        return new Complex(this.re/(a+b), (-this.im)/(a+b));
   }

   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).

   Complex div(Complex z){
      double x, a, b;

      if(z.equals(Complex.ZERO)){
         throw new ArithmeticException("/ by 0");
      }

      x = ((z.re*z.re) + (z.im*z.im));
      a = (((z.re*this.re) + (z.im*this.im))/x);
      b = (((z.re*this.im) - (z.im*this.re))/x);
         return new Complex(a, b);
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.

   Complex conj(){
      return new Complex(this.re, -this.im);
   }
   
   // Re()
   // Return the real part of this.

   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.

   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).

   double abs(){
      return Math.sqrt((this.re*this.re) + (this.im*this.im));
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.

   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex.
   // The String returned will be readable by the constructor Complex(String s)

   public String toString(){
      if(this.re * this.im != 0){
         if(this.im > 0){
            return this.re + "+" + this.im + "i";
      }   else return
             Double.toString(this.re) + Double.toString(this.im) + "i";
      
      } else if(this.re == 0) return this.im + "i";
          else return Double.toString(this.re);
      }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.

   public boolean equals(Object obj){
      Complex z = (Complex)obj;
         return this.re == z.re && this.im == z.im;
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.

   static Complex valueOf(double a, double b){
      return new Complex(a, b);
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.

   static Complex valueOf(double a){
      return new Complex(a);
   }

   // valueOf()
   // Return a new Complex constructed from s.

   static Complex valueOf(String s){
      return new Complex(s);
   }

}
