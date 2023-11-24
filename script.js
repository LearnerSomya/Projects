const scroll = new LocomotiveScroll({
    el: document.querySelector('#main'),
    smooth: true
});
//Navigation bar Animation
function firstPageAnimation(){
    var tl = gsap.timeline(); 

    tl.from("#nav",{
        y: '-10',
        opacity:0,
        duration: 1.5,
        ease: Expo.easeInOut,
    })

    .to(".boundingelem",{
        y: 0,
        ease: Expo.easeInOut,
        duration: 2,
        delay: -1,
        stagger: .2
    })
    .from("#herofooter",{
        y: -10,
        opacity: 0,
        duration: 1.5,
        delay: -1,
        ease: Expo.easeInOut
    })
}
firstPageAnimation();
function MouseCircleEliptical(){
    var xscale = 1;
    window.addEventListener("mousemove", function(detils){
        
    });
}
// Mouse Circle 
function MouseCircleFollow(){
    //here mousemove is inbuilt control which refelects movement of mouse
    window.addEventListener("mousemove", function(detils){
        //console.log(detils);
        //console.log(detils.clientX, detils.clientY);
        document.querySelector("#mousecircle").style.transform = `translate(${detils.clientX}px, ${detils.clientY}px)`;
         
        //
    })
} 
MouseCircleFollow(); 