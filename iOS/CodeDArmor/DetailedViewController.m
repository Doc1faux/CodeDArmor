//
//  DetailedViewController.m
//  Code d'Armor
//
//  Created by Quentin de Quelen on 20/05/2014.
//  Copyright (c) 2014 Quentin deQuelen. All rights reserved.
//

#import "DetailedViewController.h"
#import "IIViewDeckController.h"
@interface DetailedViewController ()

@end

@implementation DetailedViewController

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
    self.navigationItem.leftBarButtonItem = self.editButtonItem;
    [self.viewDeckController closeOpenView];
}
- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return YES;
}
- (BOOL)onUnhandledMessage:(NSDictionary *)message
{
    return NO;
}

- (BOOL)onUnhandledEvent:(NSString *)event withData:(NSDictionary *)data andCallback:(NSString *)callback
{
    
    return NO;
}

- (BOOL)onUnhandledCallback:(NSString *)callback withData:(NSDictionary *)data
{
    if ([callback isEqualToString:@"share"]) {
        NSString * link = [NSString stringWithFormat:@"%@",[data objectForKey:@"link"]];
        UIActivityViewController *activityViewController = [[UIActivityViewController alloc] initWithActivityItems:@[link] applicationActivities:nil];
        [self presentViewController:activityViewController animated:YES completion:nil];
    }
    return NO;
}

- (IBAction)backButton:(id)sender
{
    [self.navigationController popViewControllerAnimated:YES];
}

- (IBAction)shareButton:(id)sender {
    [self sendEvent:@"share" withData:nil andCallback:@"share"];
}

- (BOOL)gestureRecognizer:(UIGestureRecognizer *)gestureRecognizer shouldReceiveTouch:(UITouch *)touch {
    if ( [gestureRecognizer isMemberOfClass:[UITapGestureRecognizer class]] ) {
        // Return NO for views that don't support Taps
    } else if ( [gestureRecognizer isMemberOfClass:[UISwipeGestureRecognizer class]] ) {
        // Return NO for views that don't support Swipes
    }
    
    return YES;
}
@end
