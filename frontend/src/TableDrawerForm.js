
import {addNewTable} from "./Client";
import {LoadingOutlined} from "@ant-design/icons";

import {Drawer,  Col, Select, Form, Row, Button} from 'antd';
import {errorNotification, successNotification} from "./Notification";


const {Option} = Select;


const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

function TableDrawerForm({ showDrawer, setShowDrawer}) {

    const onCLose = () => setShowDrawer(false);

    const onFinish = table => {

        console.log(JSON.stringify(table, null, 2))
        addNewTable(table)
            .then(() => {
                console.log("table added")
                onCLose();
                successNotification(
                    "guest successfully added",
                    `Table was added to the system`
                )

            }).catch(err => {
            console.log(err);
            err.response.json().then(res => {
                console.log(res);
                errorNotification(
                    "There was an issue",
                    `${res.message} [${res.status}] [${res.error}]`,
                    "bottomLeft"
                )
            });
        }).finally(() => {

        })
    };


    const onFinishFailed = errorInfo => {
        alert(JSON.stringify(errorInfo, null, 2));
    };

    return <Drawer
        title="Create new table"
        width={720}
        onClose={onCLose}
        visible={showDrawer}
        bodyStyle={{paddingBottom: 80}}
        footer={
            <div
                style={{
                    textAlign: 'right',
                }}
            >
                <Button onClick={onCLose} style={{marginRight: 8}}>
                    Cancel
                </Button>
            </div>
        }
    >
        <Form layout="vertical"
              onFinishFailed={onFinishFailed}
              onFinish={onFinish}
              hideRequiredMark>

            <Row>
                <Col span={12}>
                    <Form.Item >
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Col>
            </Row>
        </Form>
    </Drawer>



}

export default TableDrawerForm;