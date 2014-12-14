#import "com_codenameone_compass_CompassNativeImpl.h"

@interface com_codenameone_compass_CompassNativeImpl ()
@property (retain, nonatomic) CLLocationManager* locationManager;
@property (retain, nonatomic) CLHeading* currentHeading;
@end


@implementation com_codenameone_compass_CompassNativeImpl

-(void)init{
    self.currentHeading = [[CLHeading alloc] init];
    self.locationManager = [[CLLocationManager alloc] init];
    self.locationManager.desiredAccuracy = kCLLocationAccuracyBest;
    self.locationManager.headingFilter = 1;
    self.locationManager.delegate = self;
    [self.locationManager startUpdatingHeading];
}

-(void)end{
}

-(BOOL)isSupported{
    return NO;
}

#pragma Location Manager Methods

- (void)locationManager:(CLLocationManager *)manager didUpdateHeading:(CLHeading *)newHeading
{
    self.currentHeading = newHeading;
    //self.headingLabel.text = [NSString stringWithFormat:@"%d", (int) newHeading.magneticHeading];
}

- (BOOL) locationManagerShouldDisplayHeadingCalibration:(CLLocationManager *)manager
{
    if (self.currentHeading == nil) {
        return YES;
    } else {
        return NO;
    }
    
}


@end
