package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.四组合模式composite;

public interface Component {
    void operation();
}

// 叶子组件
interface Leaf extends Component{

}

// 容器组件
interface Composite extends Component{
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
}