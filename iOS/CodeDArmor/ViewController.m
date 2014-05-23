//
//  ViewController.m
//  Cobalt
//
//  Created by Quentin deQuelen on 20/05/2014.
//  Copyright (c) 2014 Quentin deQuelen. All rights reserved.
//

#import "ViewController.h"
#import "IIViewDeckController.h"
@interface ViewController ()

@end

@implementation ViewController
- (void)viewDidLoad
{
    [super viewDidLoad];
    
    // Do any additional setup after loading the view from its nib.
    [self setDelegate:self];
    [self.navigationController setNavigationBarHidden:YES];
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#pragma mark -
#pragma mark COBALT DELEGATE METHODS
#pragma mark -
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

- (BOOL)onUnhandledMessage:(NSDictionary *)message
{
    return NO;
}

- (BOOL)onUnhandledEvent:(NSString *)event withData:(NSDictionary *)data andCallback:(NSString *)callback
{
    if ([event isEqualToString:@"PlayVideo"]) {
        NSString * link = [NSString stringWithFormat:@"%@",[data objectForKey:@"link"]];
        [[UIApplication sharedApplication] openURL:[NSURL URLWithString:link]];
        return YES;
    }
    return NO;
}

- (BOOL)onUnhandledCallback:(NSString *)callback withData:(NSDictionary *)data
{
    return NO;
}

- (IBAction)showMenu:(id)sender {
    if (menuIsOpen == true) {
        [self.viewDeckController closeOpenView];
    }else{
        [self.viewDeckController openLeftView];
    }
    
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    NSLog(@"center will appear");
    menuIsOpen = false;
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
    NSLog(@"center did appear");
    menuIsOpen = false;
    
}

- (void)viewWillDisappear:(BOOL)animated {
    [super viewWillDisappear:animated];
    NSLog(@"center will disappear");
}

- (void)viewDidDisappear:(BOOL)animated {
    [super viewDidDisappear:animated];
    NSLog(@"center did disappear");
}
@end
