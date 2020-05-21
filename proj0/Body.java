import java.lang.Math;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        return Math.sqrt(Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2));
    }

    public double calcForceExertedBy(Body b) {
        double G = 6.67 * Math.pow(10, -11);
        double distance = Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2);
        return G * this.mass * b.mass/ distance ;
    }

    public double calcForceExertedByX(Body b){
            double dx = this.xxPos - b.xxPos;
            if (this.xxPos < b.xxPos) {
                dx = -dx;
            }
        return this.calcForceExertedBy(b) * dx / this.calcDistance(b);
    }

    public double calcForceExertedByY(Body b){
        double dy = this.yyPos - b.yyPos;
        if (this.yyPos < b.yyPos) {
            dy = -dy;
        }
        return this.calcForceExertedBy(b) * dy / this.calcDistance(b);
    }

    public double calcNetForceExertedByX(Body[] list){
        double fx = 0;
        for (Body body : list) {
            /* Pass if target body is inside the array */
            if (this == body) {
                continue;
            }
            double dy = body.xxPos - this.xxPos;
            fx = fx + this.calcForceExertedBy(body) * dy / this.calcDistance(body);
        }
        return fx;
    }

    public double calcNetForceExertedByY(Body[] list){
        double fy = 0;
        /* Pass if target body is inside the array */
        for (Body body : list) {
            /* Pass if target body is inside the array */
            if (this == body) {
                continue;
            }
            double dy = body.yyPos - this.yyPos;
            fy = fy + this.calcForceExertedBy(body) * dy / this.calcDistance(body);
        }
        return fy;
    }
    public void update(double t, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy/ this.mass;
        this.xxVel = this.xxVel + t* ax;
        this.yyVel = this.yyVel + t* ay;
        this.xxPos = this.xxPos + (t * this.xxVel);
        this.yyPos = this.yyPos + (t * this.yyVel);
    }

    public void draw(){
        String img_path = "images/" +this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, img_path);
    }
}

