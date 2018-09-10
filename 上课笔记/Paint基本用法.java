			Paint 基本使用
			《Paint的方法主要可以抽象成两大类》：
			 
			 1.1 负责设置获取图形绘制、路径相关的
				1.setStyle(Paint.Style style) 
				设置画笔样式，取值有
				Paint.Style.FILL :填充内部
				Paint.Style.FILL_AND_STROKE ：填充内部和描边
				Paint.Style.STROKE ：仅描边、
				注意STROKE、FILL_OR_STROKE与FILL模式下外轮廓的位置会扩大。
				2.setStrokeWidth(float width) 
				设置画笔宽度 
				3.setAntiAlias(boolean aa) 
				设置画笔是否抗锯齿 
				4.setStrokeCap(Paint.Cap cap) ------demo演示 
				设置线冒样式，取值有Cap.ROUND(圆形线冒)、Cap.SQUARE(方形线冒)、Paint.Cap.BUTT(无线冒) 
				注意：冒多出来的那块区域就是线帽！就相当于给原来的直线加上一个帽子一样，所以叫线帽 
				
				5.setStrokeJoin(Paint.Join join) ------ demo演示
				设置线段连接处样式，取值有：Join.MITER（结合处为锐角）、Join.Round(结合处为圆弧)、Join.BEVEL(结合处为直线) 
				
				6.setStrokeMiter(float miter) 
				设置笔画的倾斜度，90度拿画笔与30拿画笔，画出来的线条样式肯定是不一样的吧。（事实证明，根本看不出来什么区别好吗……囧……）
			
			
				void reset() 
				清空画笔复位。

				void set(Paint src) 
				设置一个外来Paint画笔。

				7.void setARGB(int a, int r, int g, int b) 
				int getAlpha() 
				void setAlpha(int a) 
				int getColor() 
				void setColor(int color) 
				获取与设置alpha值、颜色、ARGB等。

				final boolean isAntiAlias() 
				8.void setAntiAlias(boolean aa) 
				获取与设置是否使用抗锯齿功能，会消耗较大资源，绘制图形速度会变慢，一般会开启。设置后会平滑一些；

				final boolean isDither() 
				9.void setDither(boolean dither) 
				获取与设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满、图像更加清晰。
				
				10.setPathEffect(PathEffect effect);   
				* 设置绘制路径的效果，如点画线等 
				（1）、CornerPathEffect——圆形拐角效果 
					paint.setPathEffect(new CornerPathEffect(100));
					利用半径R=50的圆来代替原来两条直线间的夹角
				（2）、DashPathEffect——虚线效果 
					
					//画同一条线段,偏移值为15  
					paint.setPathEffect(new DashPathEffect(new float[]{20,10,50,100},15));
					intervals[]：表示组成虚线的各个线段的长度；整条虚线就是由intervals[]中这些基本线段循环组成的。比如，我们定义new float[] {20,10}；那这个虚线段就是由两段线段组成的，第一个可见的线段长为20，每二个线段不可见，长度为10；
					phase：
					开始绘制的偏移值 
					
					.....
				
				11.setXfermode(Xfermode xfermode);   
				设置图形重叠时的处理方式，如合并，取交集或并集，经常用来制作橡皮的擦除效果
				
				12.setMaskFilter(MaskFilter maskfilter);   
				设置MaskFilter，可以用不同的MaskFilter实现滤镜的效果，如滤化，立体等 
				
				13.setColorFilter(ColorFilter colorfilter);   
				设置颜色过滤器，可以在绘制颜色时实现不用颜色的变换效果
				14.setShader(Shader shader);   
				设置图像效果，使用Shader可以绘制出各种渐变效果   
       
				15.setShadowLayer(float radius ,float dx,float dy,int color);   
				在图形下面设置阴影层，产生阴影效果，radius为阴影的角度，dx和dy为阴影在x轴和y轴上的距离，color为阴影的颜色  
				

			1.2 负责设置获取文字相关的
			
				float getFontSpacing() 
				获取字符行间距。
				float getLetterSpacing() 
				void setLetterSpacing(float letterSpacing) 
				设置和获取字符间距
				
				final boolean isUnderlineText() 
				void setUnderlineText(boolean underlineText) 
				是否有下划线和设置下划线。
				final boolean isStrikeThruText() 
				void setStrikeThruText(boolean strikeThruText) 
				获取与设置是否有文本删除线。
				
				float getTextSize() 
				void setTextSize(float textSize) 
				获取与设置文字大小，注意：Paint.setTextSize传入的单位是px，TextView.setTextSize传入的单位是sp，注意使用时不同分辨率处理问题。
				
				Typeface getTypeface() 
				Typeface setTypeface(Typeface typeface) 
				获取与设置字体类型。Android默认有四种字体样式：BOLD(加粗)、BOLD_ITALIC(加粗并倾斜)、ITALIC(倾斜)、NORMAL(正常)，我们也可以通过Typeface类来自定义个性化字体。
				
				float getTextSkewX() 
				void setTextSkewX(float skewX) 
				获取与设置文字倾斜，参数没有具体范围，官方推荐值为-0.25，值为负则右倾，为正则左倾，默认值为0。
				
				Paint.Align getTextAlign() 
				void setTextAlign(Paint.Align align) 
				获取与设置文本对齐方式，取值为CENTER、LEFT、RIGHT，也就是文字绘制是左边对齐、右边还是局中的。

				setSubpixelText(boolean subpixelText)
				固定的几个范围：320*480，480*800，720*1280，1080*1920等等；那么如何在同样的分辨率的显示器中增强显示清晰度呢？
				亚像素的概念就油然而生了，亚像素就是把两个相邻的两个像素之间的距离再细分，再插入一些像素，这些通过程序加入的像素就是亚像素。在两个像素间插入的像素个数是通过程序计算出来的，一般是插入两个、三个或四个。
				所以打开亚像素显示，是可以在增强文本显示清晰度的，但由于插入亚像素是通过程序计算而来的，所以会耗费一定的计算机性能。
				
				int breakText(String text, boolean measureForwards, float maxWidth, float[] measuredWidth) 
				比如文本阅读器的翻页效果，我们需要在翻页的时候动态折断或生成一行字符串，这就派上用场了~

				
				
				计算指定参数长度能显示多少个字符，同时可以获取指定参数下可显示字符的真实长度，譬如：
				
				private static final String STR = "动脑ABCDEF";
				mPaint.setTextSize(50);
				float[] value = new float[1];
				int ret = mPaint.breakText(STR, true, 200, value);
				Log.i("YYYY", "breakText="+ret+", STR="+STR.length()+", value="+value[1]);
				//breakText=5, STR=8, value=195.0

				void getTextBounds(char[] text, int index, int count, Rect bounds) 
				void getTextBounds(String text, int start, int end, Rect bounds) 
				获取文本的宽高，通过bounds的Rect拿到整型。

				float measureText(String text) 
				float measureText(CharSequence text, int start, int end) 
				float measureText(String text, int start, int end) 
				float measureText(char[] text, int index, int count) 
				粗略获取文本的宽度，和上面的getTextBounds比较类似，返回浮点数。

				int getTextWidths(String text, int start, int end, float[] widths) 
				int getTextWidths(String text, float[] widths) 
				int getTextWidths(CharSequence text, int start, int end, float[] widths) 
				int getTextWidths(char[] text, int index, int count, float[] widths) 
				精确计算文字宽度，与上面两个类似。