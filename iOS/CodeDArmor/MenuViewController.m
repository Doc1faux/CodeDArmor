//
//  MenuViewController.m
//  Code d'Armor
//
//  Created by Quentin de Quelen on 20/05/2014.
//  Copyright (c) 2014 Quentin deQuelen. All rights reserved.
//

#import "MenuViewController.h"
#import "IIViewDeckController.h"
@interface MenuViewController ()

@end

@implementation MenuViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    [self setDelegate:self];
}
- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}
- (BOOL)onUnhandledMessage:(NSDictionary *)message
{
    return NO;
}

- (BOOL)onUnhandledEvent:(NSString *)event withData:(NSDictionary *)data andCallback:(NSString *)callback
{
    if ([event isEqualToString:@"switchFragment"]) {
        NSString * page = [NSString stringWithFormat:@"%@",[data objectForKey:kJSPage]];
        UIViewController * navigationViewController ;
        if ([page isEqualToString:@"eventsList"]) {
            navigationViewController = [CobaltViewController getViewControllerForController:@"default" andPage:@"eventsList.html"];
        }else if([page isEqualToString:@"photosList"]){
            navigationViewController = [CobaltViewController getViewControllerForController:@"default" andPage:@"photosList.html"];
        }else if([page isEqualToString:@"videoslist"]){
            navigationViewController = [CobaltViewController getViewControllerForController:@"default" andPage:@"videoslist.html"];
        }else if([page isEqualToString:@"slideList"]){
            navigationViewController = [CobaltViewController getViewControllerForController:@"default" andPage:@"slideList.html"];
        }
        UINavigationController *navController = [[UINavigationController alloc] initWithRootViewController:navigationViewController];
        navController.title=page;
        self.viewDeckController.centerController = navController;
        
        [self.viewDeckController toggleLeftViewAnimated:YES];
        return YES;
    }
    return NO;
}

- (BOOL)onUnhandledCallback:(NSString *)callback withData:(NSDictionary *)data
{
    NSLog(@"callback is : %@",callback);
    return NO;
}

- (void)viewWillAppear:(BOOL)animated {
    
    [super viewWillAppear:animated];
    NSLog(@"%@ will appear", NSStringFromIIViewDeckSide([self.viewDeckController sideForController:self]));
    menuIsOpen = true;
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
    NSLog(@"%@ did appear", NSStringFromIIViewDeckSide([self.viewDeckController sideForController:self]));
}

- (void)viewWillDisappear:(BOOL)animated {
    [super viewWillDisappear:animated];
    NSLog(@"%@ will disappear", NSStringFromIIViewDeckSide([self.viewDeckController sideForController:self]));
    menuIsOpen = false;
}

- (void)viewDidDisappear:(BOOL)animated {
    [super viewDidDisappear:animated];
    NSLog(@"%@ did disappear", NSStringFromIIViewDeckSide([self.viewDeckController sideForController:self]));
}
@end
