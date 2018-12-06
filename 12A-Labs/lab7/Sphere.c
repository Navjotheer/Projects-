/*
 * Sphere.c
 * Navjot Heer
 * nsheer
 * lab7
 * Prints out the volume and surface area of a sphere
 */
 
#include<stdio.h> 
#include<math.h>

int main(){
    double radius,surface_area, volume;
    const  double pi = 3.141592654;

    printf("Enter the radius of the sphere: ");
    scanf("%lf", &radius);
    volume = 4.0/3.0*pi*pow(radius,3);
    surface_area = 4.0*pi*pow(radius,2);
    printf("The volume is %f", volume);
    printf(" and the surface area is %f.\n", surface_area);

    return 0;
}
    
    
    
