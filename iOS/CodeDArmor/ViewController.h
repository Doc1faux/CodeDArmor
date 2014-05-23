//
//  ViewController.h
//  Cobalt
//
//  Created by Quentin deQuelen on 20/05/2014.
//  Copyright (c) 2014 Quentin deQuelen. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CobaltViewController.h"
@interface ViewController : CobaltViewController <CobaltDelegate>

- (IBAction)showMenu:(id)sender;
@property bool menuIsOpen;
@end
