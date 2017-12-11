package com.aop.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * ����
 * @Author Zhang Lei
 * @Date 2017/12/11
 */
public class Aspect {

    private static Logger logger = LogManager.getLogger();
    String strLog = null ;

    /**
     * ǰ��֪ͨ����ĳ���ӵ�֮ǰִ�е�֪ͨ�������֪ͨ������ֹ���ӵ�ǰ��ִ��
     * @param jp ���ӵ㣺����ִ�й����е�ĳһ��Ϊ�����磬AServiceImpl.barA()�ĵ��û����׳����쳣��Ϊ
     */
    public void doBefore(JoinPoint jp) {
        strLog = "log Begining method: "
            + jp.getTarget().getClass().getName() + "."
            + jp.getSignature().getName();
        logger.warn(strLog);
    }
    /**
     * ����֪ͨ����Χһ�����ӵ��֪ͨ�������ڷ����ĵ���ǰ������Զ������Ϊ��Ҳ����ѡ��ִ��
     * ����Web��Servlet�淶�е�Filter��doFilter������
     * @param pjp ��ǰ�����е����ӵ�
     * @return
     * @throws Throwable
     */
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        time = System.currentTimeMillis() - time;
        System.out.println("process time: " + time + " ms");
        return retVal;
    }
    /**
     * �׳��쳣��֪ͨ �� �ڷ����׳��쳣�˳�ʱִ�е�֪ͨ��
     * @param jp ���ӵ㣺����ִ�й����е�ĳһ��Ϊ�����磬AServiceImpl.barA()�ĵ��û����׳����쳣��Ϊ
     */
    public void doAfter(JoinPoint jp) {
        strLog ="doAfter:log Ending method: "
            + jp.getTarget().getClass().getName() + "."
            + jp.getSignature().getName();
        logger.warn(strLog);
    }
}
