package environments;

import java.util.HashMap;
import java.util.Map;

public class EnvData {
    
    public static Map<int[], String> layout;
    public static int[][] collision_matrix;

    /* i know this is not a 'correct' way to design environments, but it works and there are bigger issues 
    to worry about; for example, climate change or the perils of late stage capitalism. */

    public static void env1() {
        layout = new HashMap<int[], String>();

        // row 13 
        layout.put(new int[]{0,13},"dark 1x1");
        layout.put(new int[]{1,13},"orange rect 2x1");
        layout.put(new int[]{3,13},"dark 1x1");
        layout.put(new int[]{4,13},"grass1 1x1");
        layout.put(new int[]{5,13},"orange grass 3x1");
        layout.put(new int[]{8,13},"c1 top right 1x1");
        layout.put(new int[]{9,13},"spikes up1 1x1");
        layout.put(new int[]{10,13},"spikes up2 1x1");
        layout.put(new int[]{11,13},"spikes up1 1x1");
        layout.put(new int[]{12,13},"spikes up1 1x1");
        layout.put(new int[]{13,13},"spikes up2 1x1");
        layout.put(new int[]{14,13},"spikes up2 1x1");
        layout.put(new int[]{15,13},"leftvine3 1x1");
        layout.put(new int[]{15,13},"spikes up1 1x1");
        layout.put(new int[]{16,13},"rect 3x1");
        layout.put(new int[]{19,13},"dark 1x1");
        layout.put(new int[]{20,13},"dark 1x1");
        layout.put(new int[]{21,13},"rect2 2x1");
        layout.put(new int[]{23,13},"dark 1x1");
        layout.put(new int[]{24,13},"dark 1x1");
        layout.put(new int[]{25,13},"dark 1x1");
        layout.put(new int[]{26,13},"rect1 2x1");
        layout.put(new int[]{27,13},"dark 1x1");  
        layout.put(new int[]{28,13},"dark 1x1");
        layout.put(new int[]{29,13},"dark 1x1");
        layout.put(new int[]{30,13},"dark 1x1"); 
        layout.put(new int[]{31,13},"c1 bot right 1x1");  
        layout.put(new int[]{32,13},"rightvine3 1x1");   

        // row 12
        layout.put(new int[]{0,12},"dark+vine 1x1");
        layout.put(new int[]{1,12},"dark 1x1");
        layout.put(new int[]{2,12},"dark 1x1");
        layout.put(new int[]{3,12},"dark 1x1");
        layout.put(new int[]{4,12},"rightvine2 1x1");
        layout.put(new int[]{4,12},"topgrass3 1x1");
        layout.put(new int[]{5,12},"topgrass1 1x1");
        layout.put(new int[]{6,12},"bush3 1x1");
        layout.put(new int[]{7,12},"topgrass2 1x1");
        layout.put(new int[]{8,12},"topgrass3 1x1");
        layout.put(new int[]{15,12},"leftvine2 1x1");
        layout.put(new int[]{16,12},"dark 1x1");
        layout.put(new int[]{17,12},"dark 1x1");
        layout.put(new int[]{18,12},"dark 1x1");
        layout.put(new int[]{19,12},"dark 1x1");
        layout.put(new int[]{20,12},"dark 1x1");
        layout.put(new int[]{21,12},"dark 1x1");
        layout.put(new int[]{23,12},"orange rect 2x1");
        layout.put(new int[]{22,12},"dark 1x1");
        layout.put(new int[]{25,12},"dark 1x1");
        layout.put(new int[]{26,12},"dark 1x1");
        layout.put(new int[]{27,12},"dark 1x1");
        layout.put(new int[]{28,12},"rect 3x1");
        layout.put(new int[]{31,12},"dark 1x1");
        layout.put(new int[]{32,12},"rightvine3 1x1");
        layout.put(new int[]{32,12},"lights 1x1");
        layout.put(new int[]{33,12},"hang grass 1x1");
        
        
        // row 11
        layout.put(new int[]{0,11},"c2 top left 1x1");
        layout.put(new int[]{1,11},"grass 2x1");
        layout.put(new int[]{3,11},"c1 top right 1x1");
        layout.put(new int[]{4,11},"rightvine1 1x1");
        layout.put(new int[]{15,11},"leftvine1 1x1");
        layout.put(new int[]{16,11},"c1 top left 1x1");
        layout.put(new int[]{17,11},"dark 1x1");
        layout.put(new int[]{18,11},"rect3 2x1");
        layout.put(new int[]{20,11},"dark 1x1");
        layout.put(new int[]{21,11},"dark+vine 1x1");
        layout.put(new int[]{22,11},"dark 1x1");
        layout.put(new int[]{23,11},"dark 1x1");
        layout.put(new int[]{24,11},"pond 6x1");
        layout.put(new int[]{30,11},"orange rect 2x1");
        layout.put(new int[]{32,11},"dark 1x1");
        layout.put(new int[]{33,11},"c1 bot right 1x1");
        layout.put(new int[]{34,11},"rightvine2 1x1");

        // row 10
        layout.put(new int[]{2,10},"topgrass1 1x1");
        layout.put(new int[]{3,10},"bush1 1x1");
        layout.put(new int[]{6,10},"lights 1x1");
        layout.put(new int[]{7,10},"hang grass 1x1");
        layout.put(new int[]{8,10},"lights 1x2");
        layout.put(new int[]{16,10},"bush2 1x1");
        layout.put(new int[]{28,10},"tiny bush 1x1");
        layout.put(new int[]{29,10},"cornervine2 1x1");
        layout.put(new int[]{30,10},"dark 1x1");
        layout.put(new int[]{31,10},"dark 1x1");
        layout.put(new int[]{32,10},"rect2 2x1");
        layout.put(new int[]{34,10},"rightvine3 1x1");
        // row 9
        layout.put(new int[]{0,9},"rock 2x2");
        layout.put(new int[]{5,9},"leftvine3 1x1");
        layout.put(new int[]{6,9},"c1 bot left 1x1");
        layout.put(new int[]{7,9},"dark 1x1");
        layout.put(new int[]{8,9},"c1 bot right 1x1");
        layout.put(new int[]{9,9},"rightvine1 1x1");
        layout.put(new int[]{11,9},"hang grass 1x1");
        layout.put(new int[]{12,9},"lights 1x2");
        layout.put(new int[]{13,9},"lights 1x1");
        layout.put(new int[]{23,9},"bush on rock 5x2");
        layout.put(new int[]{29,9},"leftvine1 1x1");
        layout.put(new int[]{31,9},"dark 1x1");
        layout.put(new int[]{30,9},"dark+vine 1x1");
        layout.put(new int[]{32,9},"dark 1x1");
        layout.put(new int[]{33,9},"dark 1x1");
        layout.put(new int[]{34,9},"rightvine2 1x1");
    
        // row 8
        layout.put(new int[]{5,8},"leftvine2 1x1");
        layout.put(new int[]{6,8},"c1 top left 1x1");
        layout.put(new int[]{7,8},"grass1 1x1");
        layout.put(new int[]{8,8},"c2 top right 1x1");
        layout.put(new int[]{9,8},"rightvine2 1x1");
        layout.put(new int[]{10,8},"leftvine3 1x1");
        layout.put(new int[]{11,8},"c1 bot left 1x1");
        layout.put(new int[]{12,8},"dark 1x1");
        layout.put(new int[]{13,8},"c1 bot right 1x1");
        layout.put(new int[]{14,8},"rightvine2 1x1");

        layout.put(new int[]{29,8},"leftvine2 1x1");
        layout.put(new int[]{30,8},"c1 top left 1x1");
        layout.put(new int[]{31,8},"grass2 1x1");
        layout.put(new int[]{32,8},"grass1 1x1");
        layout.put(new int[]{33,8},"c2 top right 1x1");
        layout.put(new int[]{34,8},"rightvine1 1x1");

        // row 7
        layout.put(new int[]{6,7},"topgrass1 1x1");
        layout.put(new int[]{7,7},"stub 1x1");
        layout.put(new int[]{8,7},"tiny bush 1x1");
        layout.put(new int[]{10,7},"leftvine2 1x1");
        layout.put(new int[]{11,7},"c2 top left 1x1");
        layout.put(new int[]{12,7},"grass2 1x1");
        layout.put(new int[]{13,7},"c2 top right 1x1");
        layout.put(new int[]{14,7},"rightvine1 1x1");

        layout.put(new int[]{25,7},"lights 1x1");
        layout.put(new int[]{26,7},"lights 1x3");
        layout.put(new int[]{27,7},"lights 1x2");

        layout.put(new int[]{30,7},"tiny bush 1x1");
        layout.put(new int[]{33,7},"bush2 1x1");

        // row 6
        layout.put(new int[]{13,6},"bush2 1x1");

        layout.put(new int[]{24,6},"leftvine2 1x1");
        layout.put(new int[]{25,6},"c2 bot left 1x1");
        layout.put(new int[]{26,6},"dark 1x1");
        layout.put(new int[]{27,6},"c1 bot right 1x1");
        layout.put(new int[]{28,6},"rightvine3 1x1");

        // row 5
        layout.put(new int[]{11,5},"rock 2x2");

        layout.put(new int[]{24,5},"leftvine1 1x1");
        layout.put(new int[]{25,5},"c1 top left 1x1");
        layout.put(new int[]{26,5},"grass1 1x1");
        layout.put(new int[]{27,5},"c2 top right 1x1");
        layout.put(new int[]{28,5},"rightvine2 1x1");

        layout.put(new int[]{34,5},"hang grass 1x1");
        layout.put(new int[]{35,5},"lights 1x2");
        layout.put(new int[]{36,5},"hang grass 1x1");

        // row 4
        
        layout.put(new int[]{25,4},"topgrass1 1x1");
        layout.put(new int[]{26,4},"bush1 1x1");
        layout.put(new int[]{27,4},"topgrass2 1x1");
        

        layout.put(new int[]{29,4},"hang grass 1x1");
        layout.put(new int[]{30,4},"hang grass 1x1");

        layout.put(new int[]{30,4},"tree 4x4");

        layout.put(new int[]{33,4},"leftvine1 1x1");
        layout.put(new int[]{34,4},"c1 bot left 1x1");
        layout.put(new int[]{35,4},"dark 1x1");
        layout.put(new int[]{36,4},"c2 bot right 1x1");
        layout.put(new int[]{37,4},"rightvine2 1x1");

        // row 3
        layout.put(new int[]{28,3},"leftvine2 1x1");
        layout.put(new int[]{29,3},"c1 bot left 1x1");
        layout.put(new int[]{30,3},"c2 bot right 1x1");
        layout.put(new int[]{31,3},"rightvine1 1x1");

        layout.put(new int[]{33,3},"leftvine2 1x1");
        layout.put(new int[]{34,3},"c2 top left 1x1");
        layout.put(new int[]{35,3},"grass2 1x1");
        layout.put(new int[]{36,3},"c2 top right 1x1");
        layout.put(new int[]{37,3},"rightvine3 1x1");

        // row 2
        layout.put(new int[]{17,2},"tree 7x9");

        layout.put(new int[]{28,2},"leftvine3 1x1");
        layout.put(new int[]{29,2},"c2 top left 1x1");
        layout.put(new int[]{30,2},"c1 top right 1x1");
        layout.put(new int[]{31,2},"rightvine2 1x1");

        layout.put(new int[]{34,2},"tiny bush 1x1");
        layout.put(new int[]{35,2},"topgrass1 1x1");
        layout.put(new int[]{36,2},"topgrass2 1x1");

        // row 1
        layout.put(new int[]{29,1},"topgrass1 1x1");
        layout.put(new int[]{30,1},"bush3 1x1");

        
        

        // collision matrix
        collision_matrix = new int[][] {
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0}, // 0
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0}, // 1
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0,0}, // 2
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0,0}, // 3
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0,0}, // 4
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0}, // 5
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0}, // 6
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0}, // 7
            {0, 0,  0,  0,  0,  0,  1,  1,  1,  0,  0,  1,  1,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0,0}, // 8
            {0, 0,  0,  0,  0,  0,  1,  1,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0,0}, // 9
            {0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0,0}, // 10
            {1, 1,  1,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,0}, // 11
            {1, 1,  1,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,0}, // 12
            {1, 1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,0}, // 13
        };
        }
}