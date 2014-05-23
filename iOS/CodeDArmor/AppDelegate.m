//
//  AppDelegate.m
//  Cobalt
//
//  Created by Quentin deQuelen on 20/05/2014.
//  Copyright (c) 2014 Quentin deQuelen. All rights reserved.
//

#import "AppDelegate.h"
#import "ViewController.h"
#import "Cobalt.h"
#import "CobaltViewController.h"
#import "MenuViewController.h"
#import "IIViewDeckController.h"
#define UIColorFromRGB(rgbValue) [UIColor colorWithRed:((float)((rgbValue & 0xFF0000) >> 16))/255.0 green:((float)((rgbValue & 0xFF00) >> 8))/255.0 blue:((float)(rgbValue & 0xFF))/255.0 alpha:1.0]
#define DEBUG_COBALT    1

@implementation AppDelegate
@synthesize navigationViewController;
- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    // Override point for customization after application launch.
    self.window.backgroundColor = [UIColor clearColor];
    
    [Cobalt setResourcePath:RESOURCE_PATH];
    navigationViewController = [CobaltViewController getViewControllerForController:@"default" andPage:@"eventsList.html"];
    UIViewController * menuViewController = [CobaltViewController getViewControllerForController:@"menuView" andPage:@"sideMenu.html"];
    UINavigationController *navController = [[UINavigationController alloc] initWithRootViewController:navigationViewController];

    //navbar color
    [[UINavigationBar appearance] setBarTintColor:UIColorFromRGB(0x4A90E2)];
    NSShadow *shadow = [[NSShadow alloc] init];
    shadow.shadowColor = [UIColor colorWithRed:0.0 green:0.0 blue:0.0 alpha:0.8];
    shadow.shadowOffset = CGSizeMake(0, 0);
    [[UINavigationBar appearance] setTitleTextAttributes: [NSDictionary dictionaryWithObjectsAndKeys:
                                                           [UIColor colorWithRed:245.0/255.0 green:245.0/255.0 blue:245.0/255.0 alpha:1.0], NSForegroundColorAttributeName,
                                                           shadow, NSShadowAttributeName,
                                                           [UIFont fontWithName:@"GujaratiSangamMN" size:21.0], NSFontAttributeName, nil]];
    
       
    IIViewDeckController* Controller =  [[IIViewDeckController alloc] initWithCenterViewController:navController
                                                                                    leftViewController:menuViewController];
    Controller.panningMode = IIViewDeckFullViewPanning;
    Controller.leftSize = 80;
    self.window.rootViewController = Controller;
    [self.window makeKeyAndVisible];
    return YES;
}

							
- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}



@end
