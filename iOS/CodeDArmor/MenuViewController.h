//
//  MenuViewController.h
//  Code d'Armor
//
//  Created by Quentin de Quelen on 20/05/2014.
//  Copyright (c) 2014 Quentin deQuelen. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CobaltViewController.h"
#import "ViewController.h"
@interface MenuViewController : CobaltViewController <CobaltDelegate>
@property bool menuIsOpen;
@end
