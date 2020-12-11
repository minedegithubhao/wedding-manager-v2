package com.qh.venus.achilles.framework.idgen;

import java.io.IOException;


/**
 * @ClassName: BuildIdFactory
 * @Description: 全局ID生产工厂
 * @author zhangfeng
 *
 */
public final class BuildIdFactory {

	private static volatile IdGenerator idGenerator;
	private static volatile BuildIdFactory instance;
	
    private final static String TAB_NAME="global";
	private BuildIdFactory() {
	}

	public static BuildIdFactory getInstance() {
		if (idGenerator == null) {
			synchronized (IdGenerator.LoadIdGeneratorConfig.class) {
				try {
					idGenerator = IdGenerator.LoadIdGeneratorConfig.loadConfig.buildIdGenerator();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (instance == null) {
			synchronized (BuildIdFactory.class) {
				instance = new BuildIdFactory();
			}
		}
		return instance;
	}

	public Long buildFactoryId(final String tableName) {
		return idGenerator.next(tableName);
	}

	public Long buildFactoryId() {
		return idGenerator.next(TAB_NAME);
	}
}
