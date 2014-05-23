//
//  DetailedViewController.h
//  Code d'Armor
//
//  Created by Quentin de Quelen on 20/05/2014.
//  Copyright (c) 2014 Quentin deQuelen. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CobaltViewController.h"
@interface DetailedViewController : CobaltViewController <CobaltDelegate>

- (IBAction)backButton:(id)sender;
- (IBAction)shareButton:(id)sender;

@end
