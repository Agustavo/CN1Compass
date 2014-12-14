#import <Foundation/Foundation.h>

@interface com_codenameone_compass_CompassNativeImpl : NSObject<CLLocationManagerDelegate> {
}

-(void)init;
-(void)end;
-(BOOL)isSupported;
@end
